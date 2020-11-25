package domain;

import util.LottoValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {
    private final String NUMBER_DELIMITER = ", ";

    private List<Integer> numbers;

    public LottoNumbers() {}

    private LottoNumbers(List<Integer> numbers) {
        LottoValidator.checkDuplicateNumber(numbers);
        this.numbers = numbers;
    }

    public LottoNumbers from(List<Integer> numbers) {
        return new LottoNumbers(numbers);
    }

    public LottoNumbers createLottoNumbers(String stringNumbers) {
        return new LottoNumbers().from(
                Arrays.stream(stringNumbers.split(NUMBER_DELIMITER))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList())
        );

    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
