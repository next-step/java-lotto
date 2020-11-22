package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Numbers {
    public static final int START_NUM = 1;
    public static final int END_NUM = 46;
    private Set<Number> numbers;

    public Numbers(Builder builder) {
        this.numbers = new HashSet<>(builder.numbers);

        checkDuplication(builder.numbers);

        builder.numbers.clear();
    }

    public static Builder builder() {
        return new Builder();
    }

    private void checkDuplication(List<Number> numbers) {
        if (this.numbers.size() != numbers.size())
            throw new IllegalArgumentException("Duplicate numbers in list to make set");
    }

    public Set<Number> getNumbers() {
        return numbers;
    }

    public int countSameNumber(Numbers numbers) {
        return (int) this.numbers.stream()
                .filter(numbers::contains)
                .count();
    }

    public boolean contains(Number number) {
        return this.numbers.contains(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Numbers numbers1 = (Numbers) o;
        return Objects.equals(numbers, numbers1.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    public int getSize() {
        return this.numbers.size();
    }


    public static final class Builder {
        private static final List<Number> lottoNumbers = getLottoNumbers();
        private List<Number> numbers = new ArrayList<>();

        private static List<Number> getLottoNumbers() {
            return IntStream.range(START_NUM, END_NUM)
                    .mapToObj(Number::new)
                    .collect(Collectors.toList());
        }

        public Builder limit(int size) {
            numbers = numbers.stream().limit(size).collect(Collectors.toList());

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
