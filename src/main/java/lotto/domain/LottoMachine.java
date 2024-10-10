package lotto.domain;

import java.util.Objects;

public class LottoMachine {

    private final Lotto lotto;

    public LottoMachine() {
        this.lotto = new Lotto();
    }

    public int lottoCount(int money) {
        return lotto.calculateCount(money);
    }

    public Lotto generateLotto() {
        return lotto.pickLottoNumber();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof LottoMachine))
            return false;
        LottoMachine that = (LottoMachine)o;
        return Objects.equals(lotto, that.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lotto);
    }
}
