package lottery.domain.vo;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class LotteryNumbers {
    private Set<Integer> numbers;

    public LotteryNumbers(Set<Integer> numbers) {
        if (numbers.size() != 6)
            throw new IllegalArgumentException("로또 번호는 6개만 가능합니다");

        this.numbers = numbers;
    }

    public LotteryNumbers(String numbersString) {
        this(Arrays.stream(numbersString.split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toSet()));
    }

    public Set<Integer> numbers(){
        return this.numbers;
    }

    public Long matchNumbersCount(Set<Integer> otherNumbers) {
        return numbers().stream()
                .filter(otherNumbers::contains)
                .count();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LotteryNumbers that = (LotteryNumbers) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
