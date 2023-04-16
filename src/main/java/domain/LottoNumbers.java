package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {
    private List<Integer> numbers;

    public LottoNumbers() {}

    private LottoNumbers(List<Integer> numbers) {
        checkDuplicateNumber(numbers);
        this.numbers = numbers;
    }

    public LottoNumbers from(List<Integer> numbers) {
        return new LottoNumbers(numbers);
    }

    public LottoNumbers createLottoNumbers(String[] stringNumbers) {
        return new LottoNumbers().from(
                Arrays.stream(stringNumbers)
                        .map(Integer::parseInt)
                        .collect(Collectors.toList())
        );

    }

    public void checkDuplicateNumber(List<Integer> numbers) {
        long uniqueLength = numbers.stream()
                .distinct()
                .count();

        if(uniqueLength != numbers.size()) {
            throw new IllegalArgumentException("중복된 숫자를 가질 수 없습니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
