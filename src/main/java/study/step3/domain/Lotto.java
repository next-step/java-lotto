package study.step3.domain;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import study.step3.domain.exception.LottoException;

import static study.step3.domain.LottoGenerator.LOTTO_NUMBERS_SIZE;

public class Lotto {

    private final List<LottoNumber> lottoNumbers;
    private boolean isBonus = false;
    private int hitCount = 0;

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
        lottoNumbers.forEach(number -> calculate(number, winningNumbers, bonusNumber));
        return Rank.valueOf(hitCount, isBonus);
    }

    private void calculate(LottoNumber number, WinningNumbers winningNumbers, LottoNumber bonusNumber) {
        winningNumbers(number, winningNumbers);
        bonusNumber(number, bonusNumber);
    }

    private void winningNumbers(LottoNumber number, WinningNumbers winningNumbers) {
        if (winningNumbers.containsNumber(number)) {
            hitCount += 1;
        }
    }

    private void bonusNumber(LottoNumber number, LottoNumber bonusNumber) {
        if (number.matchesBonusNumber(bonusNumber)) {
            isBonus = true;
        }
    }

    public List<LottoNumber> lottoNumbers() {
        return lottoNumbers;
    }

}
