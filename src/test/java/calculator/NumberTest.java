package calculator;

import calculator.domain.Number;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class NumberTest {

    @DisplayName("Number의 valueOf 정적 팩토리 메서드는")
    @Nested
    class Describe_valueOf {

        @DisplayName("숫자를 입력할 경우, 생성자로 넘긴 매개변수를 값으로 가진다.")
        @Test
        void constructor() {
            final Number number = Number.valueOf(1);
            assertThat(number.value()).isEqualTo(1);
        }

        @DisplayName("숫자로된 문자열을 입력할 경우, 생성자로 넘긴 매개변수를 값으로 가진다.")
        @Test
        void it_has_parsedInt() {
            final Number number = Number.valueOf("1");
            assertThat(number.value()).isEqualTo(1);
        }

        @DisplayName("숫자가 아닌 문자열을 입력할 경우, NumberFormatException을 발생시킨다.")
        @Test
        void it_throws_numberFormatException() {
            assertThatThrownBy(() -> Number.valueOf("메롱"))
                    .isInstanceOf(NumberFormatException.class);
        }
    }

}
