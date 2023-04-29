package lotto.domain;

import java.util.Set;

import static lotto.constants.Constants.MAX_NUMBER;
import static lotto.constants.Constants.MIN_NUMBER;
import static lotto.constants.Constants.REQUIRED_LOTTO_NUMBERS;

public class LottoNumbers {

    private Set<Integer> lottoNumbers;

    public LottoNumbers(Set<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
        validate();
    }

    private void validate() {
        if (this.lottoNumbers.size() != REQUIRED_LOTTO_NUMBERS) {
            throw new IllegalArgumentException("로또 번호는 서로 다른 " + REQUIRED_LOTTO_NUMBERS + " 개의 번호로 구성되어야 합니다.");
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
