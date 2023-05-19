package lotto.domain.lotto;

public class Store {

    public static LottoBundle order(Money money) {
        return new LottoBundle(decideCount(money));
    }

    public static Money orderManual(Money money, int manualOrderCount) {
        validateCount(manualOrderCount);
        validateMoney(money.amount(), manualOrderCount);
        return new Money(money.amount() - manualOrderCount * Lotto.PURCHASE_UNIT);
    }

    private static void validateCount(int manualOrderCount) {
        if (manualOrderCount < 0) {
            throw new IllegalArgumentException("수동로또 구매숫자는 음수가 될 수 없습니다. 입력숫자 > " + manualOrderCount);
        }
    }

    private static void validateMoney(int amount, int manualOrderCount) {
        if (amount / Lotto.PURCHASE_UNIT < manualOrderCount) {
            throw new IllegalArgumentException("로또를 구매하기에 돈이 부족합니다.");
        }
    }


    private static int decideCount(Money money) {
        return money.amount() / Lotto.PURCHASE_UNIT;
    }

}
