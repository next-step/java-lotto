package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.Utils.boolToInt;

public class Numbers {
    private List<Number> numberList;

    public Numbers(Builder builder) {
        this.numberList = new ArrayList<>(builder.numbers);
        builder.numbers.clear();
    }

    public static Builder builder() {
        return new Builder();
    }

    public List<Number> getNumberList() {
        return numberList;
    }

    public int countSameNumber(Numbers numbers) {
        return this.numberList.stream()
                .mapToInt(number -> boolToInt(numbers.contains(number)))
                .sum();
    }

    public boolean contains(Number number) {
        return this.numberList.contains(number);
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
        public static final int LOTTO_START_NUM = 1;
        public static final int LOTTO_END_NUM = 46;
        private static final List<Number> lottoNumbers = getLottoNumbers();
        private List<Number> numbers = new ArrayList<>();

        private static List<Number> getLottoNumbers() {
            return IntStream.range(LOTTO_START_NUM, LOTTO_END_NUM)
                    .mapToObj(Number::new)
                    .collect(Collectors.toList());
        }

        public Builder subNumbers(int fromIdx, int toIdx) {
            numbers = numbers.subList(fromIdx, toIdx);

            return this;
        }

        public Builder range(int startInclusive, int endExclusive) {
            IntStream.range(startInclusive, endExclusive).forEach(this::add);

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

        public Builder add(int number) {
            numbers.add(lottoNumbers.get(number - 1));

            return this;
        }

        public Numbers build() {
            return new Numbers(this);
        }
    }
}
