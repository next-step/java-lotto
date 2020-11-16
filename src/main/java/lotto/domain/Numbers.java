package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.Utils.boolToInt;

public class Numbers {
    private List<Integer> numberList;

    public Numbers(List<Integer> numberList) {
        this.numberList = new ArrayList<>(numberList);
    }

    public Numbers(Builder builder) {
        this.numberList = builder.numbers;
    }

    public static Builder builder() {
        return new Builder();
    }

    public List<Integer> getNumberList() {
        return numberList;
    }

    public int countSameNumber(Numbers numbers) {
        return this.numberList.stream()
                .reduce(0, (count, num) -> count + boolToInt(numbers.contains(num)));
    }

    public boolean contains(int num) {
        return this.numberList.contains(num);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Numbers numbers1 = (Numbers) o;
        return Objects.equals(numberList, numbers1.numberList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberList);
    }


    public static final class Builder {
        private List<Integer> numbers;

        public Builder range(int startInclusive, int endExclusive) {
            numbers = IntStream.range(startInclusive, endExclusive)
                    .boxed()
                    .collect(Collectors.toList());

            return this;
        }

        public Builder subNumbers(int fromIdx, int toIdx) {
            numbers = numbers.subList(fromIdx, toIdx);

            return this;
        }

        public Builder shuffle() {
            Collections.shuffle(numbers);

            return this;
        }

        public Builder sort() {
            Collections.sort(numbers);

            return this;
        }

        public Numbers build() {
            return new Numbers(this);
        }
    }
}
