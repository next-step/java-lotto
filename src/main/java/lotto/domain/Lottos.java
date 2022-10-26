package lotto.domain;

import lotto.strategy.NumberList;
import lotto.utils.Tickets;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lottos {

    private final BigDecimal amount;
    private List<Lotto> lottoLists;

    public Lottos(BigDecimal amount) {
        validateAmount(amount);
        this.amount = amount;
    }

    private void validateAmount(BigDecimal amount) {
        BigDecimal baseAmount = new BigDecimal(1000);
        if (amount.compareTo(baseAmount) == -1) {
            throw new IllegalArgumentException("천 원 이상 내세요.");
        }
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public List<Lotto> getLottoList() {
        return lottoLists;
    }

    public int getNumberOfTickets(BigDecimal amount) {
        return Tickets.getNumberOfTickets(amount);
    }

    public Lottos buyLottos(int tryNum, NumberList numberList) {
        List<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < tryNum; i++) {
            lottoList.add(
                    new Lotto(numberList.makeNumberList())
            );
        }

        this.lottoLists = lottoList;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottos lottos = (Lottos) o;
        return Objects.equals(amount, lottos.amount) && Objects.equals(lottoLists, lottos.lottoLists);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, lottoLists);
    }
}
