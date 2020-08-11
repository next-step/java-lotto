package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @Test
    @DisplayName("로또 생성 및 사이즈 확인")
    void generateAuto() {
        // given
        final int count = 100;
        Lottos lottos = new Lottos();

        // when
        lottos.generateAuto(count);

        // then
        assertThat(lottos.size()).isEqualTo(count);
    }

    @Test
    @DisplayName("로또 추가 및 사이즈 확인")
    void add() {
        // given
        final int count = 10;
        Lottos lottos = new Lottos();

        // when
        for (int i = 0; i < count; i++) {
            lottos.add(Lotto.generateAuto());
        }

        // then
        assertThat(lottos.size()).isEqualTo(count);
    }

}
