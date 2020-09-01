package cc.oakk.lotto.model;

import cc.oakk.lotto.util.ValidationAdapters;
import cc.oakk.lotto.view.printer.Printable;
import cc.oakk.lotto.view.printer.Printer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static cc.oakk.lotto.util.ValidationAdapters.throwIfNull;

public class Lottos implements Printable<Lottos> {
    private final List<Lotto> lottos;

    public Lottos() {
        this.lottos = new ArrayList<>();
    }

    public Lottos(List<Lotto> lottos) {
        lottos.forEach(ValidationAdapters::throwIfNull);
        this.lottos = lottos;
    }

    public Lottos add(Lotto lotto) {
        lottos.add(throwIfNull(lotto));
        return this;
    }

    public int size() {
        return lottos.size();
    }

    public LottoResults getResults(WinningLotto comparingLotto) {
        throwIfNull(comparingLotto);
        return new LottoResults(lottos.stream()
                .map(l -> LottoResult.of(l, comparingLotto))
                .collect(Collectors.toList()));
    }

    public List<Lotto> get() {
        return lottos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottos lottos = (Lottos) o;
        return Objects.equals(this.lottos, lottos.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }

    @Override
    public void print(Printer<Lottos> printer) {
        printer.print(this);
    }
}
