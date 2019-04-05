package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoPaper {
    private final List<Lotto> values;

    public LottoPaper(final List<Lotto> values) {
        this.values = new ArrayList<>(values);
    }

    public List<WinningOrder> viewResults(final WinningNumber winningNumber) {
        return this.values
                .stream()
                .map(value -> value.winResult(winningNumber))
                .collect(Collectors.toList())
                ;
    }

    public List<Lotto> get() {
        return new ArrayList<>(this.values);
    }

    public int getLottoSize() {
        return this.values.size();
    }

    public long getAutomaticSize() {
        return this.values
                .stream()
                .filter(Lotto::isAutomatic)
                .count()
                ;
    }

    public long getManualSize() {
        return this.values
                .stream()
                .filter(Lotto::isManual)
                .count()
                ;
    }
}
