package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class LottosTest {

    @Test
    void create() {
        List<Lotto> manualLottos = new ArrayList<>();
        List<Lotto> autoLottos = new ArrayList<>();
        Assertions.assertThatNoException().isThrownBy(() -> new Lottos(manualLottos, autoLottos));
    }
}
