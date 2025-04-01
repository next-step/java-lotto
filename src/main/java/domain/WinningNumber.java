package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static domain.LottoNumber.LOTTO_MAX_NUMBER;
import static domain.LottoNumber.LOTTO_MIN_NUMBER;

public class WinningNumber {
    private final LottoNumbers numbers;
    private final LottoNumber bonusNumber;

    public WinningNumber(String numberInput, String bonusNumberInput) {
        List<Integer> inputNumbers = fromNumberInput(numberInput);
        int bonusNumber = fromBonusNumberInput(bonusNumberInput);
        validate(inputNumbers, bonusNumber);
        this.numbers = new LottoNumbers(inputNumbers);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public boolean containsNumbers(LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    public boolean matchBonusNumber(LottoNumber lottoNumber) {
        return bonusNumber.equals(lottoNumber);
    }

    private List<Integer> fromNumberInput(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private int fromBonusNumberInput(String bonusNumberInput) {
        return Integer.parseInt(bonusNumberInput);
    }

    private void validate(List<Integer> numbers, int bonusNumber) {
        validateBonusNumber(numbers, bonusNumber);
    }

    private void validateBonusNumber(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨번호와 중복될 수 없습니다.");
        }
        if (bonusNumber < LOTTO_MIN_NUMBER || bonusNumber > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException("보너스 번호는 1~45까지 가능합니다.");
        }
    }

}
