package step2;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoNumbers {

    private final List<Integer> valueList;

    public LottoNumbers(List<Integer> valueList) {
        this.valueList = valueList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(valueList, that.valueList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valueList);
    }

    @Override
    public String toString() {
        return "[" +
                valueList.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "))
                + "]";
    }
}
