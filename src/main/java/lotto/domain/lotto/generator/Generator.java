package lotto.domain.lotto.generator;

import java.util.List;
import lotto.domain.lotto.Lotto;

public interface Generator {

    List<Lotto> generateLottos(int count);
}
