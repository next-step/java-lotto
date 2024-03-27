package lotto.domain;

import java.util.Objects;

public class LottoGroup {
    private final NumbersGenerator generator;
    private Lotto tickets;

    public LottoGroup(NumbersGenerator generator) {
        this(generator, null);
    }

    public LottoGroup(NumbersGenerator generator, Lotto tickets) {
        this.generator = generator;
        this.tickets = tickets;
    }

    public void generateTickets(Cash cash, ManualLottoGroup manualLottoGroup) {
        Lotto lotto = new Lotto();
        lotto.generateManualLottoNumbers(manualLottoGroup);
        lotto.generateLottoNumbers(this.generator.generate(), manualLottoGroup.getLeftOvers(cash));
        this.tickets = lotto;
    }

    public void saveMatchResult(WinningLotto winningLotto, Match match) {
        tickets.saveMatchResult(winningLotto, match);
    }

    public Lotto getTickets() {
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
