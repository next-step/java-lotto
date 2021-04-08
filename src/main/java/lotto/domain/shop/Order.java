package lotto.domain.shop;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.lotto.Lotto;

public class Order {
    private final Money money;
    private final List<Lotto> orderedLottoList;

    public Order(Money money, List<Lotto> orderedLottoList) {
        if (orderedLottoList.size() > (int) money.getAvailableLottoCount()) {
            throw new IllegalArgumentException("로또를 구입하기 위한 금액이 부족합니다.");
        }
        this.money = money;
        this.orderedLottoList = orderedLottoList;
    }

    public Order(Money money) {
        this.money = money;
        this.orderedLottoList = new ArrayList<>();
    }

    public boolean balanceWithdraw(Money money) {
        return this.money.withdraw(money);
    }

    public int getOrderedLottoCount() {
        return orderedLottoList.size();
    }

    public void addOrderedList(Lotto lotto) {
        orderedLottoList.add(lotto);
    }

    public Lotto getLotto(int index) {
        return orderedLottoList.get(index);
    }
}
