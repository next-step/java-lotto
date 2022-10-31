package lotto.domain;

import calculator.Operation;

import java.util.List;

public class LottoStore {

    public static final int LOTTO_PRICE = 1000;

    private final LottoStorage lottoStorage;

    public LottoStore(int purchaseAmount) {
        int count = calculate(purchaseAmount);
        this.lottoStorage = LottoStorage.create(count);
    }

    private int calculate(int purchaseAmount) {
        return Operation.DIVIDE.apply(purchaseAmount, LOTTO_PRICE);
    }

    public List<Lotto> getLotto() {
        return lottoStorage.copy();
    }
}
