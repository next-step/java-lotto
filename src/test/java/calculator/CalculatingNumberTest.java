package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CalculatingNumberTest {

    @Test
    @DisplayName("기본 생성")
    void create() {
        // given
        String param = "1";

        // when
        CalculatingNumber calculatingNumber = new CalculatingNumber(param);

        // then
        assertThat(calculatingNumber.getNumber()).isEqualTo(1);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("기본 생성 - null 또는 빈 값 입력")
    void create_nullOrEmpty(String param) {
        // given when then
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(
                        () -> new CalculatingNumber(param)
                ).withMessageMatching("양의 정수가 아닙니다. 입력값을 확인해 주세요.");
    }

    @Test
    @DisplayName("음수 입력 불가")
    void create_negativeNumber() {
        // given
        String param = "-1";

        // when then
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(
                        () -> new CalculatingNumber(param)
                ).withMessageMatching("음수는 입력할 수 없습니다.");
    }
}