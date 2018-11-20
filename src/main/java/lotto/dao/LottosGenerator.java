package lotto.dao;

import lotto.dto.Lotto;
import lotto.dto.Money;

import java.util.List;

public interface LottosGenerator {
    List<Lotto> genertate(Money money);

}
