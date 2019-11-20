package lotto.domain;

import java.util.List;

public interface LottosGenerator {

    default Lottos generate(Money money) {
        return null;
    }

    default Lottos generate(List<String> manualLottos) {
        return null;
    }
}
