package lotto.domain;

import lotto.domain.generator.AutoLottoGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGames {

    private final List<Lotto> lottoGameList = new ArrayList<>();
    private final List<Integer> lottoResult = Arrays.stream(new int[LottoConstant.LOTTO_SIZE + 1]).boxed().collect(Collectors.toList());

    public LottoGames(int gameCount) {
        gameCount /= LottoConstant.LOTTO_PRICE;
        for (int i = 0; i < gameCount; i++) {
            lottoGameList.add(new Lotto(new AutoLottoGenerator()));
        }
    }

    public LottoGames(List<Lotto> lottoGameList) {
        this.lottoGameList.addAll(lottoGameList);
    }

    protected int size() {
        return this.lottoGameList.size();
    }

    private int sum() {
        return IntStream.rangeClosed(LottoConstant.MIN_WINNING_NUM, LottoConstant.LOTTO_SIZE)
                .map(index -> LottoPrize.findPrize(index) * lottoResult.get(index))
                .sum();
    }

    public double calculateReturn() {
        return sum() / (double) (LottoConstant.LOTTO_PRICE * lottoGameList.size());
    }

    public void calculatePrizeCount(WinningLotto winningLotto) {
        lottoGameList.forEach(lotto -> {
            int matchCount = lotto.findMatchCount(winningLotto);
            int winningCount = lottoResult.get(matchCount);
            winningCount++;
            lottoResult.set(matchCount, winningCount);
        });
    }

    public List<Integer> getLottoResult() {
        return lottoResult;
    }
}
