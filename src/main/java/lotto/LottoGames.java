package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LottoGames {

    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_SIZE = 6;
    private final List<Lotto> lottoGameList = new ArrayList<>();
    private Lotto firstLotto;
    private final int[] lottoResult = new int[LOTTO_SIZE + 1];

    public LottoGames(List<String> lottoNumberList, String firstLottoNumber) {
        lottoNumberList.forEach(number -> lottoGameList.add(new Lotto(number)));
        this.firstLotto = new Lotto(firstLottoNumber);
    }

    public LottoGames(int gameCount) {
        for (int i = 0; i < gameCount; i++) {
            lottoGameList.add(new Lotto(LottoNumberGenerator.generateNumbers()));
        }
    }

    protected int size() {
        return this.lottoGameList.size();
    }

    private int sum() {
        return IntStream.range(3, LOTTO_SIZE)
                .map(index -> LottoPrize.findPrize(index) * lottoResult[index])
                .sum();
    }

    public double calculateReturn() {
        return sum() / (double)(LOTTO_PRICE * lottoGameList.size());
    }

    public void calculatePrizeCount() {
        lottoGameList.forEach(lotto -> lottoResult[lotto.findMatchCount(firstLotto)]++);
    }

    public int[] getLottoResult() {
        return lottoResult;
    }
}
