package cc.oakk.lotto.model;

import cc.oakk.lotto.view.printer.Printable;

public abstract class LottoPrize<T> implements Printable<String> {
    protected final T prize;
    protected final long value;

    public LottoPrize(T prize, long value) {
        this.prize = prize;
        this.value = value;
    }

    public long getValue() {
        return value;
    }
}
