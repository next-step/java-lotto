package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PrizeTest {

    @DisplayName("호출 테스트")
    @Test
    void checkValues() {
        assertThat(Prize.THREE.getCash()).isEqualTo(5000);
        assertThat(Prize.FOUR.getCash()).isEqualTo(50000);
    }
}