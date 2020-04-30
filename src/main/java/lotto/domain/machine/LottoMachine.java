package lotto.domain.machine;

import lotto.domain.Lotto;
import lotto.domain.Money;

import java.util.List;

@FunctionalInterface
public interface LottoMachine {
    public List<Lotto> buyLotto(Money money, List<String> manualLottoNumbers);
}
