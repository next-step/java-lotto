package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumbersTest {
    @Test
    @DisplayName("빈 당첨 번호를 생성할 수 없다.")
    void create() {
        Assertions.assertThatThrownBy(() -> new WinningNumbers(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호는 쉼표로 구분된 6개가 아닌 경우 예외발생한다.")
    void create_1() {
        Assertions.assertThatThrownBy(() -> new WinningNumbers("1,2,3,4,5,"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("1~45 사이의 숫자가 아닌 경우 예외발생한다.")
    void create_2() {
        Assertions.assertThatThrownBy(() -> new WinningNumbers("1,2,3,4,5,46"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("중복된 숫자가 있으면 예외가 발생한다.")
    void create_3() {
        Assertions.assertThatThrownBy(() -> new WinningNumbers("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
