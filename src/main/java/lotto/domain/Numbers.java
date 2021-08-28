package lotto.domain;

import java.util.List;
import java.util.Objects;

public class Numbers {

    private final List<Number> Numbers;

    public Numbers(List<Number> numbers) {
        Numbers = numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Numbers numbers = (Numbers) o;
        return Objects.equals(Numbers, numbers.Numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Numbers);
    }

}
