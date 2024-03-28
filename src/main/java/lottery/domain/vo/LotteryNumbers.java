package lottery.domain.vo;

import lottery.util.StringConverter;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryNumbers {
    public static final Integer MIN_NUMBER = 1;
    public static final Integer MAX_NUMBER = 45;
    public static final Integer SIZE = 6;
    public static final List<Integer> ALL_LIST = IntStream.rangeClosed(LotteryNumbers.MIN_NUMBER, LotteryNumbers.MAX_NUMBER).boxed().collect(Collectors.toList());
    private Set<Integer> numbers;

    public LotteryNumbers(Set<Integer> numbers) {
        if (numbers.size() != SIZE)
            throw new IllegalArgumentException("로또 번호는 6개만 가능합니다");

        this.numbers = numbers;
    }

    public LotteryNumbers(String numbersString) {
        this(lotteryNumbersConvert(numbersString));
    }

    private static Set<Integer> lotteryNumbersConvert(String numbersString){
        validateNumbersString(numbersString);
        return StringConverter.convertToIntegerSet(numbersString);
    }

    private static void validateNumbersString(String numbersString){
        if (numbersString.isBlank())
            throw new IllegalArgumentException("로또 번호는 비어있으면 안됩니다.");
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
