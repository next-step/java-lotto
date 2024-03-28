package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InputViewTest {

    @Test
    @DisplayName("숫자가 아닌 값을 입력하면 에러가 난다")
    void validate_tryNo() {
        InputView inputView = new InputView();
        assertThrows(IllegalArgumentException.class , () -> inputView.tryNo("abc"));
    }

    @Test
    @DisplayName("금액이 부족하면 에러가 난다")
    void validate_money() {
        InputView inputView = new InputView();
        assertThrows(IllegalArgumentException.class , () -> inputView.tryNo("0"));
        assertThrows(IllegalArgumentException.class , () -> inputView.tryNo("999"));
        assertThat(inputView.tryNo("1000")).isEqualTo(1);
    }

}
