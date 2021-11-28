package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Numbers {
    private static final int ZERO = 0;
    private static final int SIZE = 6;
    private static final List<Integer> baseNumbers = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());

    private final List<Integer> numbers;

    public Numbers() {
        Collections.shuffle(baseNumbers);
        this.numbers = baseNumbers.subList(ZERO, SIZE).stream().sorted().collect(Collectors.toList());
    }

    public Numbers(List<Integer> numbers) {
        checkArgumentValidation(numbers);
        this.numbers = sort(numbers);
    }

    private void checkArgumentValidation(List<Integer> numbers) {
        if(numbers.size() != 6) {
            throw new IllegalArgumentException("Numbers의 List<Integer> size는 항상 6입니다.");
        }
        if(numbers.stream().anyMatch(integer -> integer < 1 || integer > 45)) {
            throw new IllegalArgumentException("Numbers의 List<Integer> 의 멤버 Integer 값은 항상 1~45 사이 값 입니다.");
        }
    }

    private List<Integer> sort(List<Integer> numbers) {
        return numbers.stream().sorted().collect(Collectors.toList());
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public int match(Numbers prizeNumbers) {
        int count = ZERO;
        for(Integer number : this.numbers) {
            if( prizeNumbers.numbers.contains(number)) {
                count++;
            }
        }
        return count;
    }
}
