package lotto.common;

import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로또 생성기 테스트")
class LottoGeneratorTest {

    @DisplayName("로또 객체를 생성한다.")
    @Test
    void generateLotto() {
        Assertions.assertThat(LottoGenerator.generate() instanceof Lotto);
    }

    @DisplayName("입력 받은 수 만큼 로또를 생성한다.")
    @Test
    void generateLottos() {
        Assertions.assertThat(LottoGenerator.generateByLottoCount(14).size()).isEqualTo(14);
    }
}
