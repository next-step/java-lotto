package lotto.domain.model.money;

import lotto.exception.InvalidLottoMoneyException;

public class LottoMoney {

    public static final int LOTTO_PRICE = 1_000;

    private final int amount;

    private LottoMoney(int amount) {
        validate(amount);
        this.amount = amount;
    }

    public static LottoMoney of(int amount) {
        return new LottoMoney(amount);
    }

    public static LottoMoney of(String text) {
        return of(Integer.parseInt(text));
    }

    public int numberOfTickets() {
        return amount / LOTTO_PRICE;
    }

    private static void validate(int amount) {
        if (amount < 0 || amount % LOTTO_PRICE != 0) {
            throw new InvalidLottoMoneyException();
        }
    }

    public int getAmount() {
        return amount;
    }
}
