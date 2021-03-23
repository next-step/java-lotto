package step1.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step1.exception.NegativeNumberInputException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberTest {

    @DisplayName("Number 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        int inputValue = 1;

        // when
        Number number = new Number(inputValue);

        // then
        assertThat(number).isNotNull();
    }

    @DisplayName("Number 인스턴스 음수 입력시 예외처리 여부 테스트")
    @Test
    void 검증_음수() {
        // given
        int inputValue = -1;

        // when and then
        assertThatThrownBy(() -> {
            assertThat(new Number(inputValue)).isNotNull();
        }).isInstanceOf(NegativeNumberInputException.class)
                .hasMessageContaining("음수가 입력되었습니다.");

    }

    @DisplayName("Number 인스턴스 숫자가 아닌 문자열 입력시 예외처리 여부 테스트")
    @Test
    void 검증_숫자아닌문자열() {
        // given
        String inputValue = "one";

        // when and then
        assertThatThrownBy(() -> {
            assertThat(new Number(inputValue)).isNotNull();
        }).isInstanceOf(StringNumberFormatException.class)
                .hasMessageContaining("음수가 입력되었습니다.");

    }

}