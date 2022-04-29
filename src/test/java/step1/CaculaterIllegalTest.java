package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("계산기 validation 테스트")
public class CaculaterIllegalTest {

    @DisplayName("입력문자열 사이에는 빈 공백이 있어야 한다")
    @ParameterizedTest
    @ValueSource(strings = {"1 +2 + 3","3+3+3+3", "1  + 2 + 3", "14+ 2 + 3"})
    void sourceHaveToEmptySpace(String input) {
        assertThatThrownBy(() -> {
            Caculater caculater = new Caculater(input);
        }).isInstanceOf(IllegalArgumentException .class)
                .hasMessage("반드시 빈 공백이 포함되어야 합니다");
    }

    @DisplayName("입력 값이 null 문자일 경우 exception")
    @Test
    void sourceNull() {
        assertThatThrownBy(() -> {
            Caculater caculater = new Caculater(null);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값은 NULL 이 될 수 없다");
    }

    @DisplayName("입력 값이 빈공백 문자일 경우 exception")
    @Test
    void sourceEmptyString() {
        assertThatThrownBy(() -> {
            Caculater caculater = new Caculater("");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값은 비어있을 수 없다");
    }


//    @DisplayName("사칙연산 기호가 아닌 경우 exception")
//    @ParameterizedTest
//    @ValueSource(strings = {"1 x 2 + 3", "1 $ 3"})
//    void opereatorCheck(String input) {
//        assertThatThrownBy(() -> {
//            Caculater caculater = new Caculater(input);
//            caculater.result();
//        }).isInstanceOf(IllegalArgumentException.class)
//                .hasMessage("잘못된 연산기호");
//    }
}
