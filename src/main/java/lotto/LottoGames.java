package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGames {

    private static final int LOTTO_PRICE = 1000;
    private final List<Lotto> lottoGameList = new ArrayList<>();
    private String firstLottoNumber;

    public LottoGames(List<String> lottoNumberList, String firstLottoNumber) {
        lottoNumberList.forEach(number -> lottoGameList.add(new Lotto(number)));
        this.firstLottoNumber = firstLottoNumber;
    }

    public LottoGames(int gameCount) {
        for (int i = 0; i < gameCount; i++) {
            lottoGameList.add(new Lotto(LottoNumberGenerator.generateNumbers()));
        }
    }

//    public int size() {
//        return this.lottoGameList.size();
//    }

    private int sum() {
        return lottoGameList.stream()
                .mapToInt(lotto -> LottoPrize.findPrize(lotto.findMatchCount(firstLottoNumber)))
                .sum();
    }

    public double calculateReturn() {
        return sum() / (double)(LOTTO_PRICE * lottoGameList.size());
    }

}
