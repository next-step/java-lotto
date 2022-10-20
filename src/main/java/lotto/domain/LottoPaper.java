package lotto.domain;

import lotto.util.NullCheckUtil;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoPaper {

    private final List<Lotto> elements;

    public LottoPaper(final List<Lotto> elements) {
        NullCheckUtil.validate(elements);
        this.elements = elements;
    }

    public static LottoPaper from(final List<String> elements) {
        return new LottoPaper(
                elements.stream()
                        .map(Lotto::from)
                        .collect(Collectors.toList())
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoPaper that = (LottoPaper) o;
        return Objects.equals(elements, that.elements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(elements);
    }
}
