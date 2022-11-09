package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {
    private final LottoPrice price;

    public LottoStore(int ticketPrice) {
        this.price = new LottoPrice(ticketPrice);
    }

    public LottoStore(LottoPrice lottoPrice) {
        this.price = lottoPrice;
    }

    public Lotto purchase(int purchasePrice) {
        int count = price.getPurchaseCount(purchasePrice);
        List<LottoNumbers> numbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            numbers.add(LottoNumbers.random());
        }
        return new Lotto(numbers);
    }
}
