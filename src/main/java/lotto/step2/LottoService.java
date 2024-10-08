package lotto.step2;

import lotto.step2.domain.*;
import lotto.step2.ui.InputView;
import lotto.step2.ui.ResultView;

import java.util.Arrays;
import java.util.EnumMap;

public class LottoService {
    private final InputView inputView;
    private final ResultView resultView;

    private LottoResult lottoResult;

    public LottoService(final InputView inputView, final ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run(){
        int purchaseAmount = inputView.getPurchaseAmountFromUser();

        int lottoCount = buyLotto(purchaseAmount);
        Lottos lottos = createLottos(resultView, lottoCount);

        WinningNumbers winningNumbers = createWinningNumbers(inputView);

        this.lottoResult = new LottoResult(lottos, winningNumbers);
        showLottoResult();
        showLottoProfit(purchaseAmount);
    }

    private int buyLotto(int purchaseAmount){
        LottoMachine machine = new LottoMachine();
        int lottoCount = machine.buyLottos(purchaseAmount);
        resultView.showLottoCount(lottoCount);
        return lottoCount;
    }

    private Lottos createLottos(ResultView resultView, int lottoCount) {
        Lottos lottos = Lottos.create(lottoCount);
        resultView.showLottos(lottos);
        return lottos;
    }

    private WinningNumbers createWinningNumbers(InputView inputView) {
        String numbers = inputView.getWinningNumbersFromUser();
        return WinningNumbers.create(numbers);
    }

    private void showLottoResult() {
        EnumMap<LottoRank, Integer> rankInfo = initializeRankInfo();
        createLottoRankInfo(rankInfo);
        resultView.showLottoResult(rankInfo);
    }

    private void createLottoRankInfo(EnumMap<LottoRank, Integer> rankInfo) {
        LottoRank[] ranks = LottoRank.values();
        Arrays.sort(ranks, (o1, o2) -> o1.getMatchCount() - o2.getMatchCount());

        for (LottoRank rank : ranks) {
            if(rank.isNoneRank()) continue;
            int matchCount = rank.getMatchCount();
            rankInfo.put(rank, lottoResult.findMatchCount(matchCount));
        }
    }

    private static EnumMap<LottoRank, Integer> initializeRankInfo() {
        EnumMap<LottoRank, Integer> rankInfo = new EnumMap<>(LottoRank.class);
        Arrays.stream(LottoRank.values())
                .forEach(rank -> rankInfo.put(rank, 0));
        return rankInfo;
    }

    private void showLottoProfit(int purchaseAmount){
        double profitRate = lottoResult.calculateProfitRate(purchaseAmount);
        resultView.showLottoProfit(profitRate);
        showProfitStatus(profitRate);
    }

    private void showProfitStatus(double profitRate){
        ProfitStatus status = ProfitStatus.from(profitRate);
        resultView.showProfitStatus(status);
    }
}
