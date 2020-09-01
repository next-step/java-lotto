package com.lotto.domain;

public class Deposit {

    private static final int LOTTERY_PRICE = 1_000;
    private static final int BASE_PRICE = 0;
    private static final int BASE_MANUAL = 0;
    private final int amount;
    private final int manual;

    public Deposit(int money, int manual) {
        validateAmount(money);
        validateManual(money, manual);
        this.amount = money / LOTTERY_PRICE;
        this.manual = manual;
    }

    private void validateAmount(int money) throws IllegalArgumentException {
        if (money < BASE_PRICE) {
            String message = String.format("예산은 %d 이상의 값을 입력해 주세요.", BASE_PRICE);
            throw new IllegalArgumentException(message);
        }
    }

    private void validateManual(int money, int manual) throws IllegalArgumentException {
        if (manual < BASE_MANUAL) {
            String message = String.format("로또 수는 %d 이상의 값을 입력해 주세요.", BASE_MANUAL);
            throw new IllegalArgumentException(message);
        }
        if (manual > money / LOTTERY_PRICE) {
            String message = "수동으로 구매할 로또 수가 예산을 초과했습니다.";
            throw new IllegalArgumentException(message);
        }
    }

    public int getManualLotteryCount() {
        return manual;
    }

    public int getAutomaticLotteryCount() {
        return amount - manual;
    }
}
