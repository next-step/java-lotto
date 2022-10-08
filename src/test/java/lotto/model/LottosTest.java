package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class LottosTest {

    @DisplayName("로또가 여러개 생성된다.")
    @Test
    void createLottos() {
        Lottos lottos = new Lottos(
                List.of(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 6))
                )
        );
        Assertions.assertThat(lottos.getLottos()).hasSize(2);
    }

    @DisplayName("로또가 생성 되지 않았을 경우 에러를 반환한다.")
    @Test
    void validateLottos() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Lottos(null);
                });
    }
}
