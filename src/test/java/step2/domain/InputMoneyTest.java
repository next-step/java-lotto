package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.exception.InvalidNumberInputException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputMoneyTest {

    @DisplayName("InputMoney 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        int inputValue = 15000;

        // when
        InputMoney inputMoney = InputMoney.valueOf(inputValue);

        // then
        assertThat(inputMoney).isNotNull();
    }

    @DisplayName("InputMoney 인스턴스 음수 주입시 예외처리 여부 테스트")
    @Test
    void 검증_음수() {
        // given
        int inputValue = -1;

        // when and then
        assertThatThrownBy(() -> {
            InputMoney.valueOf(inputValue);
        }).isInstanceOf(InvalidNumberInputException.class)
                .hasMessageContaining("범위를 벗어난 값이 입력되었습니다.");

    }

    @DisplayName("InputMoney 인스턴스 유효한 값 주입후 이를 반환하는지에 대한 테스트")
    @Test
    void 반환() {
        // given
        int expected = 1;

        // when
        InputMoney inputMoney = InputMoney.valueOf(expected);
        int actual = inputMoney.getInputMoney();

        // then
        assertThat(actual).isEqualTo(expected);

    }

}