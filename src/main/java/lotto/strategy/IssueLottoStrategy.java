package lotto.strategy;

import java.util.List;
import lotto.domain.Lotto;

public interface IssueLottoStrategy {

    List<Lotto> issue(int number);
}
