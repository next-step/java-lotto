package step2.domain;

import java.util.Objects;

public class Marble {

    private int n;

    public Marble(int n) {
        this.n = n;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Marble marble = (Marble) o;
        return n == marble.n;
    }

    @Override
    public int hashCode() {
        return Objects.hash(n);
    }
}
