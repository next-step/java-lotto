package lotto.domain;

import java.util.List;

public interface LottoGenerator {

    Lottos generateLottos(int size);

    Lotto generateLotto();
}
