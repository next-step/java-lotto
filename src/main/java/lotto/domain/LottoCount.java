package lotto.domain;

import java.util.List;

public class LottoCount {

    private Money money;
    private List<Lotto> manualLottos;

    private LottoCount(Money money, List<Lotto> manualLottos) {
        this.money = money;
        this.manualLottos = manualLottos;
    }

    public static LottoCount of(int money, List<Lotto> manualLottos) {
        return new LottoCount(Money.from(money), manualLottos);
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
