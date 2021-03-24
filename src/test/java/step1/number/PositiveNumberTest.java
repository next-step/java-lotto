package step1.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step1.exception.NegativeNumberInputException;
import step1.exception.StringNumberFormatException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class PositiveNumberTest {

    @DisplayName("PositiveNumber 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        int inputValue = 1;

        // when
        PositiveNumber positiveNumber = new PositiveNumber(inputValue);

        // then
        assertThat(positiveNumber).isNotNull();
    }

    @DisplayName("PositiveNumber 인스턴스 음수 입력시 예외처리 여부 테스트")
    @Test
    void 검증_음수() {
        // given
        int inputValue = -1;

        // when and then
        assertThatThrownBy(() -> {
            assertThat(new PositiveNumber(inputValue)).isNotNull();
        }).isInstanceOf(NegativeNumberInputException.class)
                .hasMessageContaining("음수가 입력되었습니다.");

    }

    @DisplayName("PositiveNumber 인스턴스 숫자가 아닌 문자열 입력시 예외처리 여부 테스트")
    @Test
    void 검증_숫자아닌문자열() {
        // given
        String inputValue = "one";

        // when and then
        assertThatThrownBy(() -> {
            assertThat(new PositiveNumber(inputValue)).isNotNull();
        }).isInstanceOf(StringNumberFormatException.class)
                .hasMessageContaining("숫자가 아닌 문자열을 입력했습니다.");

    }

    @DisplayName("PositiveNumber 인스턴스가 소유한 값 반환 여부 테스트")
    @Test
    void 반환() {
        // given
        String stringValue = "1";
        int integerValue = 1;
        int expected = 1;

        // when an then
        assertAll(
                () -> assertThat(new PositiveNumber(stringValue).getPositiveNumber()).isEqualTo(expected),
                () -> assertThat(new PositiveNumber(integerValue).getPositiveNumber()).isEqualTo(expected)
        );

    }

    @DisplayName("PositiveNumber 인스턴스가 소유한 값을 기준으로 객체 비교하는지 여부 테스트")
    @Test
    void 비교() {
        // given
        String stringValue = "1";
        int integerValue = 1;
        int expected = 1;

        // when
        PositiveNumber positiveNumberByString = new PositiveNumber(stringValue);
        PositiveNumber positiveNumberByInteger = new PositiveNumber(integerValue);

        // then
        assertThat(positiveNumberByString).isEqualTo(positiveNumberByInteger);

    }

    @DisplayName("PositiveNumber 인스턴스가 소유한 값이 같으면 주소도 같은지 여부 테스트")
    @Test
    void 비교_주소값() {
        // given
        String stringValue = "1";
        int integerValue = 1;

        // when
        PositiveNumber positiveNumberByString = new PositiveNumber(stringValue);
        PositiveNumber positiveNumberByInteger = new PositiveNumber(integerValue);
        boolean actual = positiveNumberByString == positiveNumberByInteger;

        // then
        assertThat(actual).isTrue();
    }

}