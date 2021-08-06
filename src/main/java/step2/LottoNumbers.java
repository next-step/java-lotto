package step2;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoNumbers {

    private final List<Integer> valueList;

    public LottoNumbers(List<Integer> valueList) {
        this.valueList = valueList;
    }

    public int countMatch(LottoNumbers lottoNumbers) {
        return (int) this.valueList.stream()
                .filter(lottoNumbers.valueList::contains)
                .count();
    }

    public boolean contains(int number) {
        return this.valueList.contains(number);
    }

    public String toOutputString() {
        return "[" +
                valueList.stream()
                        .map(Object::toString)
                        .collect(Collectors.joining(", "))
                + "]";
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
}
