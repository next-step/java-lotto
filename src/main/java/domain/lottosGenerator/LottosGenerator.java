package domain.lottosGenerator;

import domain.Lotto;
import domain.Money;

import java.util.List;

public interface LottosGenerator {
    List<Lotto> generate(Money money);
}
