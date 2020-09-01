package cc.oakk.lotto.model;

import cc.oakk.lotto.view.printer.Printable;

import java.util.Objects;

public abstract class LottoPrize<T> implements Printable<LottoPrize<T>> {
    protected final T prize;
    protected final long value;

    public LottoPrize(T prize, long value) {
        this.prize = prize;
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoPrize<?> that = (LottoPrize<?>) o;
        return Objects.equals(prize, that.prize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prize);
    }
}
