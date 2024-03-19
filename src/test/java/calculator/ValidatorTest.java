package calculator;

import calculator.model.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class ValidatorTest {

    private Validator validator;

    @Test
    @DisplayName("숫자가 연속으로 들어올 때 exception 생성 Test")
    void check_number_duplication(){
        // given
        final String[] input = new String[] {"1","2"};
        validator = new Validator();

        // then
        assertThatThrownBy(() -> {
            validator.validate(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("연산자가 연속으로 들어올 때 exception 처리 Test")
    void check_operator_duplication(){
        // given
        final String[] input = new String[] {"1","+","-"};
        validator = new Validator();

        // then
        assertThatThrownBy(() -> {
            validator.validate(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("첫 번째 인자가 연산자일 때 Exception 처리 Test")
    void check_first_operator_duplication() {
        // given
        final String[] input = new String[] {"+", "1"};
        validator = new Validator();

        // then
        assertThatThrownBy(() -> {
            validator.validate(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("마지막 인자가 연산자일 때 Exception 처리 Test")
    void check_last_operator_duplication() {
        // given
        final String[] input = new String[] {"1", "+"};
        validator = new Validator();

        // then
        assertThatThrownBy(() -> {
            validator.validate(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("연산자가 아닌 문자가 들어갔을 때 exception 처리 Test")
    void check_valid_operator() {
        // given
        final String[] input = new String[]{"1", "+", "2", "?", "5"};
        validator = new Validator();

        // then
        assertThatThrownBy(() -> {
            validator.validate(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
