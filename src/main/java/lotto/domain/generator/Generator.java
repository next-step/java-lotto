package lotto.domain.generator;

import lotto.domain.data.Lotto;
import lotto.domain.data.ManualLotto;

import java.util.List;

public interface Generator {
    List<Lotto> generate(int autoCount, List<ManualLotto> manualLottos);
}
