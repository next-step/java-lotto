package lotto.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumbers {

    public static final int NUMBER_COUNT = 6;

    private List<LottoNumber> numbers;

    public LottoNumbers() {
        this(LottoNumberGenerator.generate());
    }

    public LottoNumbers(LottoNumbers lottoNumbers) {
        this(lottoNumbers.numbers());
    }

    public LottoNumbers(List<LottoNumber> numbers) {
        validate(numbers);

        this.numbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public static LottoNumbers toLottoNumber(String lottoNumbersText) {
        if (lottoNumbersText == null || lottoNumbersText.trim().isEmpty()) {
            throw new IllegalArgumentException("로또 번호는 비어 있을 수 없습니다.");
        }

        List<LottoNumber> lottoNumbers = Arrays.stream(lottoNumbersText.split(","))
                .map(LottoNumber::toLottoNumber)
                .collect(Collectors.toList());

        return new LottoNumbers(lottoNumbers);
    }

    public static LottoNumbers fromIntegers(List<Integer> numbers) {
        List<LottoNumber> lottoNumbers = numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        return new LottoNumbers(lottoNumbers);
    }

    public static void validate(List<LottoNumber> numbers) {
        if( numbers == null || numbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException("숫자가 빈값이거나, 개수가 맞지 않습니다. " + numbers + ", " + numbers.size());
        }

        Set<LottoNumber> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
        }
    }

    public boolean contains(LottoNumber number) {
        return numbers.contains(number);
    }

    public List<LottoNumber> numbers() {
        return numbers;
    }
}
