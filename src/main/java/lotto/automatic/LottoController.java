package lotto.automatic;

import lotto.automatic.domain.Lotto;
import lotto.automatic.domain.LottoRank;
import lotto.automatic.domain.LottoResult;
import lotto.automatic.domain.WinningLotto;
import lotto.automatic.dto.LottoBuyingMoney;
import lotto.automatic.view.InputView;
import lotto.automatic.view.OutputView;

import java.util.List;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoGame lottoGame;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoGame = new LottoGame();
    }

    public void request(){

        LottoBuyingMoney lottoBuyingMoney = getLottoMoney();
        List<Lotto> lottoList = getLottoList(lottoBuyingMoney);

        outputView.printLottoList(lottoList);

        WinningLotto winningLotto = getWinningLotto();
        List<LottoRank> lottoRankList = getMatchedLottoRanks(lottoList, winningLotto);
        LottoResult result = getResult(lottoBuyingMoney, lottoRankList);

        outputView.printLottoResult(result);

    }

    private LottoResult getResult(LottoBuyingMoney lottoBuyingMoney, List<LottoRank> lottoRankList) {
        return lottoGame.getLottoResult(lottoBuyingMoney.getInvestMoney(), lottoRankList);
    }

    private List<LottoRank> getMatchedLottoRanks(List<Lotto> lottoList, WinningLotto winningLottoNums) {
        return lottoGame.getLottoRank(lottoList, winningLottoNums);
    }

    private WinningLotto getWinningLotto() {
        return inputView.getWinningLottoNums();
    }

    private List<Lotto> getLottoList(LottoBuyingMoney lottoBuyingMoney) {
        return lottoGame.generateLotto(lottoBuyingMoney.getCountOfLotto());
    }

    private LottoBuyingMoney getLottoMoney() {
        return inputView.getLottoMoney();
    }

}
