package lotto.domain;

import lotto.domain.game.Lotto;
import lotto.domain.game.Round;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created By mand2 on 2020-11-19.
 */
public class Lottos {

    private final List<Lotto> lottos;
    private Round manualRound;
    private Round automatedRound;

    private Lottos(List<Lotto> lottos) {
        this(lottos, 0, lottos.size());
    }

    private Lottos(List<Lotto> lottos, int manualRound, int automatedRound) {
        this.lottos = lottos;
        this.manualRound = Round.from(manualRound);
        this.automatedRound = Round.from(automatedRound);
    }

    public static Lottos of(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public static Lottos of(List<Lotto> lottos, int manualRound, int automatedRound) {
        return new Lottos(lottos, manualRound, automatedRound);
    }

    public static Lottos of(List<Lotto> manual, List<Lotto> auto) {
        return of(Stream.concat(manual.stream(), auto.stream()).collect(toList()),
                manual.size(), auto.size());
    }

    public static Lottos of(Lottos manual, Lottos auto) {
        return new Lottos(Stream
                .concat(manual.list().stream(), auto.list().stream())
                .collect(toList())
                , manual.list().size()
                , auto.list().size());
    }

    public List<Lotto> list() {
        return this.lottos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottos lottos1 = (Lottos) o;
        return Objects.equals(lottos, lottos1.lottos) &&
                Objects.equals(getManualRound(), lottos1.getManualRound()) &&
                Objects.equals(getAutomatedRound(), lottos1.getAutomatedRound());
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos, getManualRound(), getAutomatedRound());
    }

    public int getManualRound() {
        return manualRound.getRound();
    }

    public int getAutomatedRound() {
        return automatedRound.getRound();
    }
}
