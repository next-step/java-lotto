package step3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.util.MathUtils;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("계산 유틸 클래스 테스트")
class MathUtilsTest {

    @Test
    @DisplayName("수익률 계산 테스트")
    void yieldTest() {
        double yield = 5;
        Assertions.assertThat(MathUtils.calculateYield(5000, 1000)).isEqualTo(yield);
    }

    @Test
    @DisplayName("소수점 계산 테스트")
    void 소수점_계산_Test() {
        double yield = 0.35;
        double v = MathUtils.calculateYield(5000, 14000);
        assertThat(MathUtils.floorDecimal(v, 2)).isEqualTo(yield);
    }

}