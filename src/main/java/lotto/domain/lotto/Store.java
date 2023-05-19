package lotto.domain.lotto;

import java.util.List;

public class Store {

    private CountableLotto countableLotto;

    public Store(CountableLotto countableLotto) {
        this.countableLotto = countableLotto;
    }

    public LottoBundle order(Money money) {
        return new LottoBundle(countableLotto.countLotto(money));
    }

    public Money orderManual(Money money, int manualOrderCount) {
        validateCount(manualOrderCount);
        validateMoney(money, manualOrderCount);
        return new Money(money.amount() - manualOrderCount * Lotto.PURCHASE_UNIT);
    }

    private static void validateCount(int manualOrderCount) {
        if (manualOrderCount < 0) {
            throw new IllegalArgumentException("수동로또 구매숫자는 음수가 될 수 없습니다. 입력숫자 : " + manualOrderCount);
        }
    }

    private void validateMoney(Money money, int manualOrderCount) {
        int maxOrderCount = countableLotto.countLotto(money);
        if (maxOrderCount < manualOrderCount) {
            throw new IllegalArgumentException("로또를 구매하기에 돈이 부족합니다. 제시한 돈 : " + money.amount() +
                    ", 최대구매가능한 갯수 : " + maxOrderCount);
        }
    }

//    private static int decideCount(Money money) {
//        return money.amount() / Lotto.PURCHASE_UNIT;
//    }

}
