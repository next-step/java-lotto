package lottogame.domain;

import lottogame.validator.InputValidatable;

public class WinningInfo implements InputValidatable<LottoNumber> {

    private final LottoNumberPackage numbers;
    private final LottoNumber bonusNumber;

    public WinningInfo(LottoNumberPackage numbers, LottoNumber bonusNumber) {
        this.numbers = numbers;
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public LottoNumberPackage getNumbers() {
        return numbers;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }

    @Override
    public boolean isInvalid(LottoNumber target) {
        return numbers.contains(target);
    }

    @Override
    public String getInvalidMessage() {
        return "보너스 번호는 당첨 번호에 없는 숫자로 선정 해 주세요.";
    }
}