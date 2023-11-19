package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.dto.ExpressionBlock;

class ExpressionTest {
    @Test
    @DisplayName("문자열 분리")
    void inputSplit() {
        String input = "2 + 3";
        assertThat(input.split(" ")).contains("2","+","3");
    }

    @Test
    @DisplayName("객체 생성")
    void create() {
        String input = "2 + 3";
        assertThat(Expression.from(input)).isInstanceOf(Expression.class);
    }

    @Test
    @DisplayName("객체 생성시 예외발생")
    void input_nullOrBlank_Exception() {
        String nullInput = null;
        String blankInput = " ";
        String emptyInput = "";
        assertThatThrownBy(()->Expression.from(nullInput)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->Expression.from(blankInput)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->Expression.from(emptyInput)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("오입력 문자열 예외발생")
    void input_Array_Exception() {
        String input = "1 + 2 + ";
        assertThatThrownBy(()->Calculator.execute(Expression.from(input))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("첫 피연산자")
    void first() {
        assertThat(Expression.from("2 + 3").first()).isEqualTo(2);
    }

    @Test
    @DisplayName("식(문자열) 길이")
    void size() {
        assertThat(Expression.from("2 + 3").size()).isEqualTo(3);
    }

    @Test
    @DisplayName("원하는 위치의 연산자와 값 반환")
    void getAsExpressionBlock() {
        assertThat(Expression.from("2 + 3").getAsExpressionBlock(1)).isEqualTo(ExpressionBlock.of(Operator.ADD, 3));
    }
}
