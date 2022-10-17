package lotto.domain.lotto;

import lotto.domain.Money.ImmutableMoney;
import lotto.domain.lottonumber.LottoNumberSet;

public class Lotto {

    protected final LottoNumberSet lottoNumbers;
    public static final ImmutableMoney LOTTO_PRICE = new ImmutableMoney(1000);

    public Lotto() {
        this(LottoNumberSet.createLottoNumberSet());
    }

    public Lotto(final LottoNumberSet lottoNumberSet) {
        this.lottoNumbers = lottoNumberSet;
    }

    @Override
    public String toString() {
        return String.format("[%s]", lottoNumbers.toString());
    }
}
