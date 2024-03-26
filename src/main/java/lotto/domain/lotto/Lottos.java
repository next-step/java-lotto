package lotto.domain.lotto;

import lotto.domain.rank.Ranks;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottos {
    private final List<Lotto> values = new ArrayList<>();

    public Lottos(String[][] lottoNumbers) {
        this(Arrays.stream(lottoNumbers)
                .map(Lotto::new)
                .collect(Collectors.toList()));
    }

    public Lottos() {}

    public Lottos(List<Lotto> values) {
        if (values != null && !values.isEmpty()) {
            this.values.addAll(values);
        }
    }

    public boolean isEmpty() {
        return values.isEmpty();
    }

    public int size() {
        return values.size();
    }

    public List<Lotto> values() {
        return Collections.unmodifiableList(this.values);
    }

    public void forEach(Consumer<Lotto> action) {
        values.forEach(action);
    }

    public Ranks ranks(WinningLotto winningLotto) {
        return new Ranks(values.stream()
                .map(lotto -> lotto.rank(winningLotto))
                .collect(Collectors.toList()));
    }

    public Lottos concat(Lottos others) {
        return new Lottos(Stream.of(this.values, others.values())
                .flatMap(Collection::stream)
                .collect(Collectors.toList()));
    }
}
