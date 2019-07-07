package com.java.lotto.domain;

import java.util.List;

public class LottoPurchase {
    private static final int LOTTO_PRICE = 1000;

    private final int purchaseAmount;
    private final List<String> manualLottoNumbers;

    public LottoPurchase(int purchaseAmount, List<String> manualLottoNumbers) {
        this.purchaseAmount = purchaseAmount;
        this.manualLottoNumbers = manualLottoNumbers;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public int getCountOfLotto() {
        return purchaseAmount / LOTTO_PRICE;
    }

    public int getCountOfAutoLotto() {
        return purchaseAmount / LOTTO_PRICE - manualLottoNumbers.size();
    }

    public int getCountOfManualLotto() {
        return manualLottoNumbers.size();
    }

    public String getManualLottoNumbers(int index) {
        return manualLottoNumbers.get(index);
    }


}
