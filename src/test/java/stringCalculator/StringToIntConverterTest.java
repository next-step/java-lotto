package stringCalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringToIntConverterTest {
    @Test
    @DisplayName("입력이 비어있는 경우 에러")
    void check_input_blank() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                Utils.checkBlank(""));
    }

    @Test
    @DisplayName("입력된 문자열을 빈칸에 의해 분리")
    void split_string_with_blank() {
        assertThat(Utils.splitString("1 2")).isEqualTo(new String[]{"1", "2"});
    }

    @Test
    @DisplayName("분리한 문자 배열의 원소는 사칙연산 혹은 숫자")
    void string_is_num_or_operator() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                Utils.checkNumOrOperators(new String[]{"1", "2", "p"}));
    }

    @Test
    @DisplayName("분리한 문자 배열의 원소는 사칙연산과 숫자가 번갈아서 존재해야 함.")
    void alternately_num_and_operator() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                Utils.checkNumAndOperatorAlternately(new String[]{"1", "+", "/"}));
    }

    @Test
    @DisplayName("분리한 문자 배열의 원소 중 마지막은 숫자로 끝나야함.")
    void last_element_is_num() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                Utils.checkLastElement(new String[]{"1", "+", "3", "/"}));
    }

}
