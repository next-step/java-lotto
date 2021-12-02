package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.utils.LottoGenerator;

class LottosTest {

    @DisplayName("Lottos가 주어졌을 때 unmodifiableList를 반환하는지 검증")
    @Test
    void unmodifiableTest() {
        Lottos lottos = new Lottos(LottoGenerator.generate(new Money(1_000)));
        assertThatThrownBy(() -> lottos.getLottos().addAll(LottoGenerator.generate(new Money(1_000))))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @DisplayName("Lottos가 주어졌을 때 lotto의 개수를 반환하는지 검증")
    @Test
    void countTest() {
        Lottos lottos = new Lottos(LottoGenerator.generate(new Money(2_000)));
        assertThat(lottos.count()).isEqualTo(2);
    }

    @DisplayName("Lottos 2개가 주어졌을 때 하나의 lottos로 병합하는지 검증")
    @Test
    void joinTest() {
        Lottos firstLottos = new Lottos(LottoGenerator.generate(new Money(2_000)));
        Lottos secondLottos = new Lottos(LottoGenerator.generate(new Money(2_000)));
        assertThat(firstLottos.join(secondLottos).count()).isEqualTo(4);
    }
}
