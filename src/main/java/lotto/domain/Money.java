package lotto.domain;

public class Money {
    public static final int LOTTO_PRICE = 1000;
    public static final String CANNOT_BUY_EVEN_ONLY_ONE_LOTTO_EXCEPTION = "돈이 부족해 1개의 로또도 살 수 없습니다.";
    public static final String MONEY_TO_GO_BACK_EXCEPTION = "로또를 구매해도 거슬러줄 금액이 존재합니다.";

    public long lottoQuantity(long fee) {
        validateMoney(fee);
        return changeToLottoCnt(fee);
    }

    private void validateMoney(long fee) {
        validateMoneyToBuyLotto(fee);
        validateMoneyToGoBack(fee);
    }

    private void validateMoneyToBuyLotto(long fee) {
        if (purchasable(fee)) {
            throw new IllegalStateException(CANNOT_BUY_EVEN_ONLY_ONE_LOTTO_EXCEPTION);
        }
    }

    private boolean purchasable(long fee) {
        return fee < LOTTO_PRICE;
    }

    private void validateMoneyToGoBack(long fee) {
        if (isLeft(fee)) {
            throw new IllegalStateException(MONEY_TO_GO_BACK_EXCEPTION);
        }
    }

    private boolean isLeft(long fee) {
        return fee % LOTTO_PRICE != 0;
    }

    private long changeToLottoCnt(long fee) {
        return fee / LOTTO_PRICE;
    }
}
