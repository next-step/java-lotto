package cc.oakk.lotto.model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberRange {
    private final int from;
    private final int to;

    public LottoNumberRange(int from, int to) {
        if (from > to) {
            throw new IllegalArgumentException("to가 from보다 커야합니다.");
        }
        this.from = from;
        this.to = to;
    }

    public static LottoNumberRange between(int from, int to) {
        return new LottoNumberRange(Math.min(from, to), Math.max(from, to));
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public boolean isValidNumber(int number) {
        return from <= number && number <= to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumberRange that = (LottoNumberRange) o;
        return from == that.from &&
                to == that.to;
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to);
    }

    public List<Integer> createRangeList() {
        return IntStream.range(from, to)
                .boxed()
                .collect(Collectors.toList());
    }
}
