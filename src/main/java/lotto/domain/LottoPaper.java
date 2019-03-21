package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoPaper {
    private final List<Lotto> values;

    public LottoPaper(final List<Lotto> values) {
        this.values = new ArrayList<>(values);
    }

    public WinningStatistics viewResults(final LottoNumbers winningNumber) {
        return new WinningStatistics(
                this.values
                        .stream()
                        .map(value -> value.howManyMatches(winningNumber))
                        .map(WinningOrder::from)
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        );
    }

    public List<Lotto> get() {
        return new ArrayList<>(this.values);
    }

    public int getLottoSize() {
        return this.values.size();
    }
}
