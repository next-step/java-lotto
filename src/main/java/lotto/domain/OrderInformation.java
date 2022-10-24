package lotto.domain;

import java.util.List;

public class OrderInformation {

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
        return money.getMoney() / LottoTickets.LOTTO_PRICE;
    }

    public int countManualTickets() {
        return manualLottos.size();
    }

    public int countAutoTickets() {
        int leftMoney = money.getMoney() - (countManualTickets() * LottoTickets.LOTTO_PRICE);
        return leftMoney / LottoTickets.LOTTO_PRICE;
    }

    public List<Lotto> getManualLottos() {
        return this.manualLottos;
    }
}
