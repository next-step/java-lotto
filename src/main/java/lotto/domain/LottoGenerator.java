package lotto.domain;

import java.util.List;

public interface LottoGenerator {

    List<Lotto> generateLottos(int size);

    Lotto generateLotto();
}
