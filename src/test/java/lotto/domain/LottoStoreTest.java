package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStoreTest {

    @Test
    @DisplayName("10 개의 로또를 생성 시 10개의 로또를 반환한다.")
    void createLottos() {
        assertThat(LottoStore.createLottos(10).count()).isEqualTo(10);
    }

}