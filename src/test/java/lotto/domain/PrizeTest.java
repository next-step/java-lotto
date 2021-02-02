package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeTest {

    @DisplayName("호출 테스트")
    @Test
    void checkValues() {
        assertThat(Prize.THREE.getCash()).isEqualTo(5000);
        assertThat(Prize.FOUR.getCash()).isEqualTo(50000);
    }
}