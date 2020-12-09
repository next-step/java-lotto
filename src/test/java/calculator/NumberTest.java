package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberTest {

    @DisplayName("숫자 객체 생성")
    @ParameterizedTest
    @ValueSource(strings = {"", "0"})
    void create(String numberValue) {
        //when
        Number number = new Number(numberValue);

        //then
        assertThat(number).isNotNull();
    }

    @DisplayName("숫자 객체 생성 - 비정상 값 입력 오류")
    @ParameterizedTest
    @ValueSource(strings = {"a", "-1"})
    void create_exception(String numberValue) {
        assertThatIllegalArgumentException()
              .isThrownBy(() -> new Number(numberValue))
              .withMessage("0 이상 숫자를 입력해주세요");
    }

    @DisplayName("덧셈")
    @Test
    void add() {
        //given
        Number x = new Number("1");
        Number y = new Number("3");

        //when
        x.add(y);

        //then
        assertEquals(x.getNumber(), 4);
    }
}
