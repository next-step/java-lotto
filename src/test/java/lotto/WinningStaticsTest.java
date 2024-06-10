package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;


class WinningStaticsTest {
    @DisplayName("당첨통계 Enum 클래스를 사용하여 설명생성 테스트")
    @ParameterizedTest
    @EnumSource
    void staticsTest(WinningStatics winningStatics) {
        String result = WinningStatics.THREE.getResult(3);
        Assertions.assertThat(result).isEqualTo("3개 일치 (5000원)- 3개");
    }
}