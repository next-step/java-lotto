package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {

    private static final int LOTTO_PRICE = 1000;
    private final List<Lotto> lottoList = new ArrayList<>();
    private final String firstLottoNumber;
    private final double lottoTotalPrice;

    public LottoTickets(List<String> lottoNumberList, String firstLottoNumber) {
        lottoNumberList.forEach(number -> lottoList.add(new Lotto(number)));
        this.firstLottoNumber = firstLottoNumber;
        this.lottoTotalPrice = LOTTO_PRICE * lottoNumberList.size();
    }

    private int sum() {
        return lottoList.stream()
                .mapToInt(lotto -> LottoPrize.findPrize(lotto.findMatchCount(firstLottoNumber)))
                .sum();
    }

    public double calculateReturn() {
        return sum() / lottoTotalPrice;
    }

}
