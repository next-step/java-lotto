package lotto.domain;

import java.util.Objects;

public class LottoGroup {
    private final NumbersGenerator generator;
    private Lottos tickets;

    public LottoGroup(NumbersGenerator generator) {
        this(generator, null);
    }

    public LottoGroup(NumbersGenerator generator, Lottos tickets) {
        this.generator = generator;
        this.tickets = tickets;
    }

    public void generateTickets(Cash cash, ManualLottoGroup manualLottoGroup) {
        Lottos lottos = new Lottos();
        lottos.generateManualLottoNumbers(manualLottoGroup);
        lottos.generateLottoNumbers(this.generator.generate(), manualLottoGroup.getLeftOvers(cash));
        this.tickets = lottos;
    }

    public void saveMatchResult(WinningLotto winningLotto, Match match) {
        tickets.saveMatchResult(winningLotto, match);
    }

    public Lottos getTickets() {
        return tickets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoGroup)) return false;
        LottoGroup that = (LottoGroup) o;
        return Objects.equals(generator, that.generator) && Objects.equals(tickets, that.tickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(generator, tickets);
    }
}
