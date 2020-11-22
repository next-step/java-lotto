package lotto.model;

import util.StringUtils;

public class Amount {
    private final static String ILLEGAL_ARGUMENT_MESSAGE = "입력 값이 잘못됐습니다.";
    private final static String ILLEGAL_PAY_MESSAGE = "잔액이 부족합니다.";
    private int amount;

    public Amount(String amount) {
        if (isInvalid(amount)) {
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT_MESSAGE);
        }

        this.amount = Integer.parseInt(amount);
    }

    public int pay(int price) {
        if (isInValidPrice(price)) {
            throw new IllegalArgumentException(ILLEGAL_PAY_MESSAGE);
        }

        return this.amount -= price;
    }

    //로또 구입 전 가격을 리턴
    public int getPrePurchaseAmount(int lottoCount, int price){
        return lottoCount * price + amount;
    }

    //price 로 음수값이 들어오는 경우
    private boolean isInValidPrice(int price) {
        return this.amount < price || price < 0;
    }


    private boolean isInvalid(String amount) {
        return amount == null || amount.isEmpty() || !StringUtils.isPositiveNumber(amount);
    }
}
