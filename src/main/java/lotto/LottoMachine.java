package lotto;

import java.util.List;
import java.util.Objects;

public class LottoMachine {

    private final LottoNumbers lottoNumbers;
    private Lotto lotto;

    public LottoMachine(LottoNumbers lottoNumbers) {
        this(lottoNumbers, new Lotto());
    }

    public LottoMachine(LottoNumbers lottoNumbers, Lotto lotto) {
        this.lottoNumbers = lottoNumbers;
        this.lotto = lotto;
    }

    public int lottoCount(int money) {
        return lotto.calculateCount(money);
    }

    public Lotto generateLotto() {
        lotto = new Lotto(pickLottoNumber());
        return lotto;
    }

    private List<Integer> pickLottoNumber() {
        return lottoNumbers.pickLottoNumber();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof LottoMachine))
            return false;
        LottoMachine that = (LottoMachine)o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lottoNumbers);
    }
}
