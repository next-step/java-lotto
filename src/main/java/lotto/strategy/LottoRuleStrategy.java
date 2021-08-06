package lotto.strategy;

import lotto.model.Lotto;
import lotto.model.LottoNumber;

import java.util.Collection;

public interface LottoRuleStrategy {
    Lotto ticketing(final Collection<LottoNumber> lottoNumbers);
}
