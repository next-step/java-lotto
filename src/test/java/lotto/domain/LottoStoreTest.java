package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStoreTest {

    @Test
    @DisplayName("입력 금액을 1000으로 나눈 값만큼 로또를 반환한다.")
    void sellLotto() {
        assertThat(new LottoStore(10000).sellLotto().count()).isEqualTo(10);
    }

}