package lotto.domain;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Lotto {
    private static final int LOTTO_SIZE = 6;

    private final Set<Integer> lotto;

    public Lotto(Set<Integer> lotto) {
        if (lotto.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }

        this.lotto = lotto;
    }

    public int match(Lotto target) {
        int count = 0;
        for (Integer lottoNumber : lotto) {
            count += target.increment(lottoNumber);
        }
        return count;
    }

    int increment(int lottoNumber) {
        if (contains(lottoNumber)) {
            return 1;
        }
        return 0;
    }

    boolean contains(int lottoNumber) {
        return lotto.contains(lottoNumber);
    }

    public static Lotto of(Set<Integer> numbers) {
        Set<Integer> lotto = new LinkedHashSet<>();
        for (Integer number : numbers) {
            lotto.add(number);
        }
        return new Lotto(lotto);
    }

    public static Lotto of(Integer... numbers) {
        Set<Integer> lotto = new LinkedHashSet<>();
        for (Integer number : numbers) {
            lotto.add(number);
        }
        return new Lotto(lotto);
    }

    public static Lotto ofComma(String text) {
        if (Objects.isNull(text)) {
            throw new IllegalArgumentException();
        }

        String[] values = text.split(",");
        Set<Integer> lotto = new LinkedHashSet<>();
        for (String value : values) {
            lotto.add(Integer.parseInt(value.trim()));
        }
        return new Lotto(lotto);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto1 = (Lotto) o;
        return Objects.equals(lotto, lotto1.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto);
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "lotto=" + lotto +
                '}';
    }
}
