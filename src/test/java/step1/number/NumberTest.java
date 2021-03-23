package step1.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step1.exception.NegativeNumberInputException;
import step1.exception.StringNumberFormatException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

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
                .hasMessageContaining("숫자가 아닌 문자열을 입력했습니다.");

    }

    @DisplayName("Number 인스턴스가 소유한 값 반환 여부 테스트")
    @Test
    void 반환() {
        // given
        String stringValue = "1";
        int integerValue = 1;
        int expected = 1;

        // when an then
        assertAll(
                () -> assertThat(new Number(stringValue).getNumber()).isEqualTo(expected),
                () -> assertThat(new Number(integerValue).getNumber()).isEqualTo(expected)
        );

    }
}