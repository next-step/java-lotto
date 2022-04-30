package lotto.domain;

import lotto.domain.LottoManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoManagerTest {

    @Test
    @DisplayName("15000원을 입력 시 15개의 로또를 반환한다.")
    void createLottos() {
        assertThat(new LottoManager().createLottos("15000").size()).isEqualTo(15);
    }
}