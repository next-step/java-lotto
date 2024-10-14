package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoAutoGeneratorTest {

    @DisplayName("로또 자동 생성기가 주문 수 만큼 로또를 잘 반환하는지")
    @Test
    void generateTest() {
        assertThat(LottoAutoGenerator.generate(5).size())
                .isEqualTo(5);
    }
}
