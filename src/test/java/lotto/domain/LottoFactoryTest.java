package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoFactoryTest {

    @DisplayName("자동 로또와 수동 로또를 생성한다.")
    @Test
    void buy() {
        Lottos lottos = LottoFactory.create(3, List.of("1,2,3,4,5,6"));

        assertThat(lottos.quantity()).isEqualTo(4);
    }
}
