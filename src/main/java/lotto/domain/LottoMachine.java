package lotto.domain;

import java.util.Objects;

public class LottoMachine {

    private static final int LOTTO_PRICE = 1_000;
    private final Money money;
    private final Lottos lottos;


    public LottoMachine(Money money) {
        this.money = money;
        this.lottos = Lottos.of(calcPossibleLottoCount());
    }

    private int calcPossibleLottoCount() {
        return this.money.getMoney().intValue() / LOTTO_PRICE;
    }

    public Lottos getLottoTickets() {
        return this.lottos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoMachine that = (LottoMachine) o;
        return Objects.equals(money, that.money) && Objects.equals(lottos, that.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(money, lottos);
    }
}
