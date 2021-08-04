package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("당첨 번호 테스트")
public class WinningNumberTest {

    @DisplayName("당첨 번호가 1이상 45이하가 아니면, Exception이 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    public void outOfBoundsWinningNumberExceptionTest(int number) {
        // when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningNumber(number))
                .withMessage("당첨 번호는 1이상 45이하 이어야 합니다.");
    }
}
