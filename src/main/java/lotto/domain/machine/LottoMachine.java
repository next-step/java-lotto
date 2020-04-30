package lotto.domain.machine;

import lotto.domain.LottoGroup;
import lotto.domain.Money;

import java.util.List;

@FunctionalInterface
public interface LottoMachine {
    public LottoGroup buyLotto(Money money, List<String> manualLottoNumbers);
}
