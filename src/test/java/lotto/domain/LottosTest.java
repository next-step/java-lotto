package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.domain.fixture.Fixture.getLottoNumbersFixture;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottosTest {
    @DisplayName("로또를 여러개 생성할 수 있다.")
    @Test
    void createLottos() {
        ManualLotto lottoA = ManualLotto.create(getLottoNumbersFixture(1, 2, 3, 4, 5, 6));
        ManualLotto lottoB = ManualLotto.create(getLottoNumbersFixture(1, 2, 3, 4, 5, 6));

        Lottos lottos = new Lottos(List.of(lottoA, lottoB));
        assertThat(lottos.values()).hasSize(2);
    }
}