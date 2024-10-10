package calculator.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static calculator.model.NumberParsing.*;
import static org.assertj.core.api.Assertions.*;

class NumberParsingTest {

    @Test
    @DisplayName("정상적인 숫자 리스트 저장 테스트")
    void 숫자_리스트_저장_테스트() {
        String[] input = new String[]{"3", "+", "2", "/", "2", "*", "3"};
        assertThat(addNumber(input)).isEqualTo(List.of(new Integer[]{3, 2, 2, 3}));
    }

    @Test
    @DisplayName("비정상적인 입력으로 숫자 리스트 저장 실패 테스트")
    void 숫자_리스트_저장_실패_테스트() {
        String[] input = new String[]{"2", "+", "a"};
        assertThatThrownBy(() -> addNumber(input))
                .isInstanceOf(NumberFormatException.class)
                .hasMessageMatching("숫자형식이 아닙니다.");
    }

}