package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.utils.LottoNumberGenerator;

class LottosTest {

    @DisplayName("Lottos가 주어졌을 때 unmodifiableList를 반환하는지 검증")
    @Test
    void unmodifiableTest() {
        Lottos lottos = new Lottos(Arrays.asList(new Lotto(LottoNumberGenerator.generate())));
        assertThatThrownBy(() -> lottos.getLottos().add(new Lotto(LottoNumberGenerator.generate())))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @DisplayName("Lottos가 주어졌을 때 lotto의 개수를 반환하는지 검증")
    @Test
    void countTest() {
        Lottos lottos = new Lottos(Arrays.asList(new Lotto(LottoNumberGenerator.generate()),
                                                 new Lotto(LottoNumberGenerator.generate())));
        assertThat(lottos.count()).isEqualTo(2);
    }

    @DisplayName("Lottos 2개가 주어졌을 때 하나의 lottos로 병합하는지 검증")
    @Test
    void joinTest() {
        Lottos firstLottos = new Lottos(Arrays.asList(new Lotto(LottoNumberGenerator.generate()),
                                                      new Lotto(LottoNumberGenerator.generate())));
        Lottos secondLottos = new Lottos(Arrays.asList(new Lotto(LottoNumberGenerator.generate()),
                                                       new Lotto(LottoNumberGenerator.generate())));
        assertThat(firstLottos.join(secondLottos).count()).isEqualTo(4);
    }
}
