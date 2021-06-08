package kr.aterilio.nextstep.techcamp.m1.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusBallTest {

    @DisplayName("보너스 볼이 1-45 범위에 속하지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    public void createBonusBallFailed_outOfRange(int bonusBall) {
        assertThatThrownBy(() -> {
            new BonusBall(bonusBall);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("범위");
    }
}
