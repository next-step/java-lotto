package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class StringAddCalculatorTest {

    @Test
    @DisplayName("SplitAndSum 기능 테스트")
    void splitAndSum() {
        String input = "1:2:3";
        StringAddCalculator stringAddCalculator = new StringAddCalculator();
        assertThat(stringAddCalculator.splitAndSum(input)).isEqualTo(6);

        String input2 = "//;\n1;2;3;4";
        assertThat(stringAddCalculator.splitAndSum(input2)).isEqualTo(10);
    }

    @Test
    @DisplayName("Null or 공백 입력시 true")
    void isBlank() {
        String input = "";
        String input2 = null;
        String input3 = "  ";

        StringAddCalculator stringAddCalculator = new StringAddCalculator();
        assertThat(stringAddCalculator.isBlank(input)).isTrue();
        assertThat(stringAddCalculator.isBlank(input2)).isTrue();
        assertThat(stringAddCalculator.isBlank(input3)).isTrue();
    }

    @Test
    @DisplayName("구분자를 기준으로 숫자 스트링 array 반")
    void split() {
        String input = "1:2:3";
        String input2 = "//;\n1;2;3";
        StringAddCalculator stringAddCalculator = new StringAddCalculator();
        assertThat(stringAddCalculator.split(input)).contains("1","2","3");
        assertThat(stringAddCalculator.split(input2)).contains("1","2","3");
    }

    @Test
    @DisplayName("String Array를 int List로 형변환 함.")
    void parseToInt() {
        String[] array = {"1", "2", "3"};

        StringAddCalculator stringAddCalculator = new StringAddCalculator();
        assertThat(stringAddCalculator.parseToInt(array)).contains(1,2,3);
    }

    @Test
    @DisplayName("숫자가 아니거나 0보다 작으면 RuntimeException을 발생시")
    void validNumber() {
        String input = "s";
        String input1 = "-1";

        StringAddCalculator stringAddCalculator = new StringAddCalculator();
        assertThatThrownBy(() -> stringAddCalculator.valid(input)).isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> stringAddCalculator.valid(input1)).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("int List의 합을 구함")
    void sum() {
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);

        StringAddCalculator stringAddCalculator = new StringAddCalculator();
        assertThat(stringAddCalculator.sum(integers)).isEqualTo(3);
    }
}
