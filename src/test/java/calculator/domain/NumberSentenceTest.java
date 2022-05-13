package calculator.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class NumberSentenceTest {

    @Test
    void 빈_문자열_일때() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new NumberSentence(""));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new NumberSentence(" "));
    }

    @Test
    void null_일때() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new NumberSentence(null));
    }

    @Test
    void 수식_요소_짝수일때() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new NumberSentence("3 / 4 *"));
    }

    @Test
    void 수식_연산자_기호_길이_1이상_일때() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new NumberSentence("3 ++ 4"));
    }

    @Test
    void 수식_연산자_기호_사칙연산이_아닐때() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new NumberSentence("3 % 4"));
    }

    @Test
    void 숫자_리스트() {
        NumberSentence numberSentence = new NumberSentence("3 + 4 / 5 * 9 - 2");

        List<Integer> numberList = numberSentence.getNumberList();

        assertThat(numberList)
                .isEqualTo(Arrays.stream(new Integer[]{3, 4, 5, 9, 2}).collect(Collectors.toList()));
    }

    @Test
    void 연산자_리스트() {
        NumberSentence numberSentence = new NumberSentence("3 + 4 / 5 * 9 - 2");

        List<Character> operationList = numberSentence.getOperationList();

        assertThat(operationList)
                .isEqualTo(Arrays.stream(new Character[]{'+', '/', '*', '-'}).collect(Collectors.toList()));
    }
}