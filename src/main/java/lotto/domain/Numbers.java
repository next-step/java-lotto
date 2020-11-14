package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    public int countSameNumber(Numbers numbers) {
        return this.numberList.stream()
                .reduce(0, (count, num) -> {
                    if (numbers.contains(num))
                        return count + 1;
                    return count;
                });
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


    public static final class Builder implements javafx.util.Builder<Numbers> {
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

        @Override
        public Numbers build() {
            return new Numbers(this);
        }
    }
}
