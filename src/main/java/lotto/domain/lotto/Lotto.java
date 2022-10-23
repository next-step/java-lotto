package lotto.domain.lotto;

import lotto.domain.lottonumber.LottoNumberSet;
import lotto.domain.money.Money;

public class Lotto {

    protected final LottoNumberSet lottoNumbers;
    public static final Money LOTTO_PRICE = new Money(1000);

    public Lotto() {
        this(LottoNumberSet.createLottoNumberSet());
    }

    public Lotto(int... ints) {
        this.lottoNumbers = new LottoNumberSet(ints);
    }

    public Lotto(final LottoNumberSet lottoNumberSet) {
        this.lottoNumbers = lottoNumberSet;
    }

    @Override
    public String toString() {
        return String.format("[%s]", lottoNumbers.toString());
    }
}
