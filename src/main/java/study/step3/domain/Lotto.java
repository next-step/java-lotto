package study.step3.domain;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import study.step3.domain.exception.LottoException;

import static study.step3.domain.LottoGenerator.LOTTO_NUMBERS_SIZE;

public class Lotto {

    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<Integer> numbers) {
        validateNumbers(numbers);
        this.lottoNumbers = numbers.stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList());
    }

    public static void validateNumbers(List<Integer> numbers) {
        if (!isValidNumbers(numbers)) {
            throw new LottoException("번호는 6자리 중복되지 않은 값이어야 합니다.");
        }
    }

    private static boolean isValidNumbers(List<Integer> numbers) {
        return new HashSet<>(numbers)
            .size() == LOTTO_NUMBERS_SIZE;
    }

    public Rank matches(WinningNumbers winningNumbers, LottoNumber bonusNumber) {
        return Rank.valueOf(hitCount(winningNumbers), isBonus(bonusNumber));
    }

    private Integer hitCount(WinningNumbers winningNumbers) {
        return lottoNumbers.stream()
            .map(winningNumbers::containsNumber)
            .map(v -> v.compareTo(false))
            .reduce(0, Integer::sum);
    }

    private boolean isBonus(LottoNumber bonusNumber) {
        return lottoNumbers.stream()
            .anyMatch(number -> number.matchesBonusNumber(bonusNumber));
    }

    public List<LottoNumber> lottoNumbers() {
        return lottoNumbers;
    }

}
