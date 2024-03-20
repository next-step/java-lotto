package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoFactoryTest {

    @Test
    @DisplayName("Ball 6개를 가진 Lotto를 생성한다")
    void generate() {
        Lotto lotto = LottoFactory.generate();
        assertThat(lotto.balls()).hasSize(6);
    }
}
