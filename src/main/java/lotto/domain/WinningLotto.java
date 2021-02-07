package lotto.domain;

import java.util.List;
import lotto.util.Validator;

public class WinningLotto implements Lotto {

    private LottoNumber BonusBall;
    private List<LottoNumber> numbers;

    public WinningLotto() {
    }

    public WinningLotto(LottoNumber bonusBall, List<LottoNumber> numbers) {
        Validator.checkSizeOfLotto(numbers);
        Validator.checkDuplicatedNumber(numbers);
        this.BonusBall = bonusBall;
        this.numbers = numbers;
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }

    public LottoNumber getBonusBall() {
        return BonusBall;
    }
}
