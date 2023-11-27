package lotto.domain;

public class Money {
    protected static final String CANNOT_BUY_EVEN_ONLY_ONE_LOTTO_EXCEPTION = "돈이 부족해 1개의 로또도 살 수 없습니다.";
    protected static final String MONEY_TO_GO_BACK_EXCEPTION = "로또를 구매해도 거슬러줄 금액이 존재합니다.";
    protected static final String NEGATIVE_NUMBER_EXCEPTION = "돈은 음수가 될 수 없습니다.";
    private static final int LOTTO_PRICE = 1000;
    private final long money;

    public Money(long money) {
        validate(money);
        this.money = money;
    }

    private void validate(long money) {
        validateMoney(money);
        validateMoneyToBuyLotto(money);
        validateMoneyToGoBack(money);
    }

    private void validateMoney(long money) {
        if (isMinus(money)) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_EXCEPTION);
        }
    }

    private boolean isMinus(long money) {
        return money < 0;
    }

    private void validateMoneyToBuyLotto(long money) {
        if (!purchasable(money)) {
            throw new IllegalStateException(CANNOT_BUY_EVEN_ONLY_ONE_LOTTO_EXCEPTION);
        }
    }

    private boolean purchasable(long money) {
        return money >= LOTTO_PRICE;
    }

    private void validateMoneyToGoBack(long money) {
        if (changeable(money)) {
            throw new IllegalStateException(MONEY_TO_GO_BACK_EXCEPTION);
        }
    }

    private boolean changeable(long money) {
        return money % LOTTO_PRICE != 0;
    }

    public long lottoQuantity() {
        return changeToLottoCnt();
    }

    private long changeToLottoCnt() {
        return money / LOTTO_PRICE;
    }
}
