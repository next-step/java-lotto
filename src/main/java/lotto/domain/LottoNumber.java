package lotto.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static lotto.domain.LottoNumberGenerator.FINAL_NUMBER;
import static lotto.domain.LottoNumberGenerator.NUMBER_COUNT;

public class LottoNumber {

    private List<Integer> numbers;


    public LottoNumber() {
        this(LottoNumberGenerator.generate());
    }

    public LottoNumber(LottoNumber lottoNumber) {
        this(lottoNumber.numbers());
    }

    public LottoNumber(List<Integer> numbers) {
        validate(numbers);

        this.numbers = numbers
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public static LottoNumber toLottoNumber(String lottoNumbersText) {
        if (lottoNumbersText == null || lottoNumbersText.trim().isEmpty()) {
            throw new IllegalArgumentException("로또 번호는 비어 있을 수 없습니다.");
        }

        List<Integer> lottoNumbers = Arrays.stream(lottoNumbersText.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return new LottoNumber(lottoNumbers);
    }

    private void validate(List<Integer> numbers) {
        if( numbers == null || numbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException("숫자가 빈값이거나, 개수가 맞지 않습니다.");
        }

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
        }

        if (uniqueNumbers.stream().anyMatch(it -> it < 1 || it > FINAL_NUMBER)) {
            throw new IllegalArgumentException("숫자는 1보다 크거나 같고, 45보다 작거나 같아야 합니다.");
        }
    }

    public List<Integer> numbers() {
        return numbers;
    }

    public LottoRank lottoRank(LottoNumber lottoWinningNumbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        int match = (int) lottoWinningNumbers.numbers()
                .stream()
                .filter(numberSet::contains)
                .count();
        return LottoRank.fromMatch(match);
    }
}
