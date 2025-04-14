package step2.domain;

import java.util.*;
import java.util.stream.Collectors;

import static step2.domain.LottoNumberGenerator.NUMBER_COUNT;

public class LottoNumbers {
    private final List<LottoNumber> numbers;

    public LottoNumbers(List<LottoNumber> numbers) {
        validate(numbers);
        this.numbers = Collections.unmodifiableList(
                numbers.stream().sorted().collect(Collectors.toList()));
    }

    public static LottoNumbers from(List<Integer> numbers) {
        List<LottoNumber> lottoNumbers = numbers.stream()
                .map(LottoNumber::from)
                .collect(Collectors.toList());
        return new LottoNumbers(lottoNumbers);
    }

    public static LottoNumbers fromText(String text) {
        List<Integer> numbers = Arrays.stream(text.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return from(numbers);
    }

    private void validate(List<LottoNumber> numbers) {
        if (numbers == null || numbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException("숫자가 빈값이거나, 개수가 맞지 않습니다.");
        }
        Set<LottoNumber> unique = new HashSet<>(numbers);
        if (unique.size() != numbers.size()) {
            throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
        }
    }

    public List<LottoNumber> numbers() {
        return numbers;
    }

    public LottoRank lottoRank(LottoNumbers winningNumbers) {
        Set<LottoNumber> winningSet = new HashSet<>(winningNumbers.numbers());
        long matchCount = numbers.stream().filter(winningSet::contains).count();
        return LottoRank.fromMatch((int) matchCount);
    }
}
