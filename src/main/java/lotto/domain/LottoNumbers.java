package lotto.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static lotto.domain.LottoNumberGenerator.NUMBER_COUNT;

public class LottoNumbers {

    private List<LottoNumber> numbers;

    public LottoNumbers() {
        this(LottoNumberGenerator.generate());
    }

    public LottoNumbers(LottoNumbers lottoNumbers) {
        this(lottoNumbers.numbers());
    }

    public LottoNumbers(List<LottoNumber> numbers) {
        validate(numbers);

        this.numbers = numbers
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public static LottoNumbers toLottoNumber(String lottoNumbersText) {
        if (lottoNumbersText == null || lottoNumbersText.trim().isEmpty()) {
            throw new IllegalArgumentException("로또 번호는 비어 있을 수 없습니다.");
        }

        List<LottoNumber> lottoNumbers = Arrays.stream(lottoNumbersText.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        return new LottoNumbers(lottoNumbers);
    }

    public static LottoNumbers fromIntegers(List<Integer> numbers) {
        List<LottoNumber> lottoNumbers = numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        return new LottoNumbers(lottoNumbers);
    }

    private void validate(List<LottoNumber> numbers) {
        if( numbers == null || numbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException("숫자가 빈값이거나, 개수가 맞지 않습니다.");
        }

        Set<LottoNumber> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
        }
    }

    public List<LottoNumber> numbers() {
        return numbers;
    }

    public LottoRank lottoRank(LottoNumbers lottoWinningNumbers) {
        Set<LottoNumber> numberSet = new HashSet<>(numbers);
        int match = (int) lottoWinningNumbers.numbers()
                .stream()
                .filter(numberSet::contains)
                .count();
        return LottoRank.fromMatch(match);
    }
}
