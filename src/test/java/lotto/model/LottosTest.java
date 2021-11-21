package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.utils.LottoNumberGenerator;

class LottosTest {

    @DisplayName("Lottos 객체가 주어졌을 때 unmodifiableList를 반환하는지 검증")
    @Test
    void unmodifiableTest() {
        Lottos lottos = new Lottos(Arrays.asList(new Lotto(LottoNumberGenerator.generate())));
        assertThatThrownBy(() -> lottos.getPurchasedLottos().add(new Lotto(LottoNumberGenerator.generate())))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
