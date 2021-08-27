package lotto.domain;

public class Money {

    public static final int ZERO = 0;
    public static final int MINIMUM_LOTTO_MONEY = 1000;

    private final int buyLottoMoney;

    private Money(int money) {
        buyLottoMoney = money;
    }

    public static Money create(String inputMoney) {
        int money = Integer.parseInt(inputMoney);

        if (money <= ZERO) {
            throw new IllegalArgumentException("금액은 1000원 이상이어야 합니다.");
        }

        if (money % MINIMUM_LOTTO_MONEY != ZERO) {
            throw new IllegalArgumentException("금액은 1000원 단위어야 합니다.");
        }

        return new Money(money);
    }

    public int purchaseLottoCount() {
        return buyLottoMoney / MINIMUM_LOTTO_MONEY;
    }


}
