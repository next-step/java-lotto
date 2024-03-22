package step2;

public class WinningNumbers {

    private final LottoNumbers numbers;
    private final LottoNumber bonusNumber;

    public WinningNumbers(LottoNumbers numbers, LottoNumber bonusNumber) {
        validateBonusNumber(numbers, bonusNumber);
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(LottoNumbers numbers, LottoNumber bonusNumber) {
        if (numbers.matchedNumber(bonusNumber.getNumber())) {
            throw new IllegalArgumentException("보너스 볼은 1등 번호와 겹칠 수 없습니다.");
        }
    }

    public LottoNumbers getNumbers() {
        return numbers;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
