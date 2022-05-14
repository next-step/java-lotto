package lotto.domain;

import lotto.exception.InvalidCash;

import java.util.List;

public class Cash {

    public static final int LOTTO_PRICE = 1000;

    private final int value;

    public Cash(int value) {
        if(value < LOTTO_PRICE) {
            throw new InvalidCash();
        }
        this.value = value;
    }
    
    public int totalLottoCount() {
        return value / LOTTO_PRICE;
    }
    
    public boolean overTotalCount(List<LottoNumbers> manualLottoNumbers) {
        return totalLottoCount() < manualLottoNumbers.size();
    }

    public double toDouble() {
        return value;
    }
}
