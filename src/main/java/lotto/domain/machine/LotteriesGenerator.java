package lotto.domain.machine;

import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.domain.Money;

import java.util.List;

@FunctionalInterface
public interface LotteriesGenerator {
    List<Lotto> generate(Money amount, List<LottoNumbers> numbers);
}
