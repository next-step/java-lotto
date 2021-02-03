package lotto.domain;

import java.util.List;

public class WinnerLotto extends Lotto {

    private final LottoNumber BonusBall;
    private final List<LottoNumber> numbers;

    public WinnerLotto(LottoNumber bonusBall, List<LottoNumber> numbers) {
        checkSizeOfLotto(numbers);
        checkDuplicatedNumber(numbers);
        checkLottoContainsBonusball(bonusBall,numbers);
        BonusBall = bonusBall;
        this.numbers = numbers;
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }

    public LottoNumber getBonusBall() {
        return BonusBall;
    }

    private void checkLottoContainsBonusball (LottoNumber bonusBall, List<LottoNumber> numbers) {
        if (numbers.contains(bonusBall)) {
            throw new IllegalArgumentException("보너스번호가 로또번호와 중복됩니다.");
        }
    }

    public static WinnerLotto of (LottoNumber bonusBall, List<LottoNumber> numbers) {
        return new WinnerLotto(bonusBall,numbers);
    }


}
