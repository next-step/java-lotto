package lotto.domain;

import java.util.Objects;

public class Buyer {
    private final String name;

    public Buyer(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Buyer buyer = (Buyer) o;
        return Objects.equals(name, buyer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
