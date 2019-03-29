package domain;

import util.WinType;

public class WinningLotto {
    private Lotto lotto;
    private LottoNo bonus;

    public WinningLotto(Lotto lotto, LottoNo bonus) {
        assert !lotto.hasNumber(bonus);

        this.lotto = lotto;
        this.bonus = bonus;
    }

    WinType figure(Lotto numbers) {
        long count = this.lotto.count(numbers);
        WinType type = WinType.findByCount(count);

        if (type.isThird() && numbers.hasNumber(bonus)) {
            return WinType.SECOND;
        }
        return type;
    }
}
