package lotto.generator;

import lotto.BonusLotto;
import lotto.LottoNumber;
import lotto.LottoNumbers;

public class BonusLottoGenerator extends MessageLottoNumberGenerator implements Generator {

    private final LottoNumber bonusNumber;

    public BonusLottoGenerator(String message, int bonus) {
        super(message);
        this.bonusNumber = new LottoNumber(bonus);
    }

    @Override
    public LottoNumbers generate() {
        return new BonusLotto(super.numbers(), bonusNumber);
    }
}
