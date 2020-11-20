package lotto.utils;

import java.util.Objects;

public class Pair<A, B> {
    private final A fst;
    private final B snd;

    public Pair(A fst, B snd) {
        this.fst = fst;
        this.snd = snd;
    }

    public boolean equals(Object other) {
        return other instanceof Pair<?, ?> &&
                Objects.equals(fst, ((Pair<?, ?>) other).fst) &&
                Objects.equals(snd, ((Pair<?, ?>) other).snd);
    }

    public int hashCode() {
        if (fst == null) return (snd == null) ? 0 : snd.hashCode() + 1;
        else if (snd == null) return fst.hashCode() + 2;
        else return fst.hashCode() * 17 + snd.hashCode();
    }
}
