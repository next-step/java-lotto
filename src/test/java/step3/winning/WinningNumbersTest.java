package step3.winning;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class WinningNumbersTest {
    @DisplayName("입력된 당첨번호가 null 이거나 비어있을경우 예외 확인")
    @ParameterizedTest
    @NullAndEmptySource
    void setWinningNumbers_null확인(String numbers){
        assertThatThrownBy(() -> {
            new WinningNumbers(numbers);
        }).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("당첨번호를 입력해주세요.");
    }

    @DisplayName("입력된 당첨번호가 쉼표로만 구분되어 었는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4.5.6", "3,4,5:1:2:6","19 2,3,4,5,1"})
    void winningNumber_쉼표구분(String numbers) {
        assertThatThrownBy(() -> {
            new WinningNumbers(numbers);
        }).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("당첨번호는 쉼표(,)로 구분되어야합니다.");
    }

    @DisplayName("입력된 당첨번호가 6개 미만일경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4", "3,4,5", "1", "9,2,3,4,5"})
    void winningNumber_6개미만_예외발생(String numbers) {
        assertThatThrownBy(() -> {
            new WinningNumbers(numbers);
        }).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("당첨번호는 6자리 숫자로 구성되어야합니다.");
    }
}