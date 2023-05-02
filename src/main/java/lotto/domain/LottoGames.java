package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LottoGames {

    private final List<Lotto> lottoGameList = new ArrayList<>();
    private final int[] lottoResult = new int[Lotto.LOTTO_SIZE + 1];

    public LottoGames(List<String> lottoNumberList) {
        lottoNumberList.forEach(number -> lottoGameList.add(new Lotto(number)));
    }

    public LottoGames(int gameCount) {
        gameCount /= Lotto.LOTTO_PRICE;
        for (int i = 0; i < gameCount; i++) {
            lottoGameList.add(new Lotto(LottoNumberGenerator.generateNumbers()));
        }
    }

    protected int size() {
        return this.lottoGameList.size();
    }

    private int sum() {
        return IntStream.range(3, Lotto.LOTTO_SIZE + 1)
                .map(index -> LottoPrize.findPrize(index) * lottoResult[index])
                .sum();
    }

    public double calculateReturn() {
        return sum() / (double)(Lotto.LOTTO_PRICE * lottoGameList.size());
    }

    public void calculatePrizeCount(Lotto firstLotto) {
        lottoGameList.forEach(lotto -> lottoResult[lotto.findMatchCount(firstLotto)]++);
    }

    public int[] getLottoResult() {
        return lottoResult;
    }
}
