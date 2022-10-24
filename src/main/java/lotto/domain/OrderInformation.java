package lotto.domain;

import java.util.List;

public class OrderInformation {

    private static final int LOTTO_PRICE = 1000;

    private Money money;
    private List<Lotto> manualLottos;

    private OrderInformation(Money money, List<Lotto> manualLottos) {
        this.money = money;
        this.manualLottos = manualLottos;
    }

    public static OrderInformation of(int money, List<Lotto> manualLottos) {
        return new OrderInformation(Money.from(money), manualLottos);
    }

    public int countTotalTickets() {
        return money.getMoney() / LOTTO_PRICE;
    }

    public int countManualTickets() {
        return manualLottos.size();
    }

    public int countAutoTickets() {
        int leftMoney = money.getMoney() - (countManualTickets() * LOTTO_PRICE);
        return leftMoney / LOTTO_PRICE;
    }

    public List<Lotto> getManualLottos() {
        return this.manualLottos;
    }
}
