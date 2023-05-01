package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGames {

    private static final int LOTTO_PRICE = 1000;
    private final List<Lotto> lottoList = new ArrayList<>();
    private String firstLottoNumber;
    private double lottoTotalPrice;

    public LottoGames(List<String> lottoNumberList, String firstLottoNumber) {
        lottoNumberList.forEach(number -> lottoList.add(new Lotto(number)));
        this.firstLottoNumber = firstLottoNumber;
        this.lottoTotalPrice = LOTTO_PRICE * lottoNumberList.size();
    }

    public LottoGames(int gameCount) {
        for (int i = 0; i < gameCount; i++) {
            lottoList.add(new Lotto(LottoNumberGenerator.generateNumbers()));
        }
    }

//    public int size() {
//        return this.lottoList.size();
//    }

    private int sum() {
        return lottoList.stream()
                .mapToInt(lotto -> LottoPrize.findPrize(lotto.findMatchCount(firstLottoNumber)))
                .sum();
    }

    public double calculateReturn() {
        return sum() / lottoTotalPrice;
    }

}
