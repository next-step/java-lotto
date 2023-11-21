package lotto.domain;

public class Money {
    public static final int LOTTO_PRICE = 1000;
    public static final String CANNOT_BUY_EVEN_ONLY_ONE_LOTTO_EXCEPTION = "돈이 부족해 1개의 로또도 살 수 없습니다.";
    public static final String MONEY_TO_GO_BACK_EXCEPTION = "로또를 구매해도 거슬러줄 금액이 존재합니다.";

    private final long money;

    public Money(long money) {
        this.money = money;
    }

    public long lottoQuantity() {
        validateMoney();
        return changeToLottoCnt();
    }

    private void validateMoney() {
        validateMoneyToBuyLotto();
        validateMoneyToGoBack();
    }

    private void validateMoneyToBuyLotto() {
        if (purchasable()) {
            throw new IllegalStateException(CANNOT_BUY_EVEN_ONLY_ONE_LOTTO_EXCEPTION);
        }
    }

    private boolean purchasable() {
        return money < LOTTO_PRICE;
    }

    private void validateMoneyToGoBack() {
        if (changeable()) {
            throw new IllegalStateException(MONEY_TO_GO_BACK_EXCEPTION);
        }
    }

    private boolean changeable() {
        return money % LOTTO_PRICE != 0;
    }

    private long changeToLottoCnt() {
        return money / LOTTO_PRICE;
    }
}
