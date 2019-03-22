package domain;

import com.google.common.primitives.Ints;
import com.sun.deploy.util.StringUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static util.Constants.*;

public class Numbers {
    private Set<Integer> numbers;

    private Numbers(Set<Integer> numbers) {
        assert numbers.size() == LOTTO_NUMBER;
        assert isValidRange(numbers);

        this.numbers = numbers;
    }

    public static Numbers of(int... numbers) {
        Set<Integer> numberSet = new HashSet<>(Ints.asList(numbers));
        return new Numbers(numberSet);
    }

    public static Numbers of(String[] numbers) {
        Set<Integer> numberSet = Arrays.stream(numbers)
                .mapToInt(it -> Integer.parseInt(StringUtils.trimWhitespace(it)))
                .boxed()
                .collect(Collectors.toSet());

        return new Numbers(numberSet);
    }

    private boolean isValidRange(Set<Integer> numbers) {
        return numbers.stream()
                .filter(it -> it < LOTTO_NUMBER_RANGE_LOW && it > LOTTO_NUMBER_RANGE_HIGH)
                .count() == 0;
    }

    long count(Numbers numbers) {
        return this.numbers.stream()
                .filter(it -> numbers.hasNumber(it))
                .count();
    }

    boolean hasNumber(int number) {
        return this.numbers.contains(number);
    }

    @Override
    public String toString() {
        return this.numbers.toString();
    }
}
