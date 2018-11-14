package utils;

import domain.Lotto;
import domain.wrapper.Money;

import java.util.List;

public interface LottoGenerator {
    List<Lotto> generate(Money money);
}
