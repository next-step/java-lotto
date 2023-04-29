package lotto.domain;

import java.util.Set;

public class LottoNumbers {

    private static final int REQUIRED_NUMBERS = 6;

    private static final int MIN_NUMBER = 1;

    private static final int MAX_NUMBER = 45;

    private Set<Integer> lottoNumbers;

    public LottoNumbers(final Set<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
        validate();
    }

    private void validate() {
        if (this.lottoNumbers.size() != REQUIRED_NUMBERS) {
            throw new IllegalArgumentException("로또 번호는 서로 다른 " + REQUIRED_NUMBERS + " 개의 번호로 구성되어야 합니다.");
        }

        for (int number : this.lottoNumbers) {
            validateNumber(number);
        }
    }

    private void validateNumber(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("잘못된 숫자: " + number + " - 숫자는 " + MIN_NUMBER + " 과 " + MAX_NUMBER + " 사이여야 합니다");
        }
    }

    public Set<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
