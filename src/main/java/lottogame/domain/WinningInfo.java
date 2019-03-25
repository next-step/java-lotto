package lottogame.domain;

import lottogame.validator.Validatable;
import lottogame.validator.WinningInfoValidator;

public class WinningInfo {

    private final LottoNumberPackage numbers;
    private final LottoNumber bonusNumber;

    private final Validatable<WinningInfo> validator = new WinningInfoValidator();

    public WinningInfo(LottoNumberPackage numbers, String inputLine) {
        this(numbers, LottoNumber.getInstance(Integer.parseInt(inputLine)));
    }

    public WinningInfo(LottoNumberPackage numbers, LottoNumber bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
        validator.validate(this);
    }

    public LottoNumberPackage getNumbers() {
        return numbers;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}