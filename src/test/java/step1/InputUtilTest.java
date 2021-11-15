package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step1.util.InputUtil;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
public class InputUtilTest {
    @Test
    @DisplayName("String input 을 Array 로 잘 반환하는지 test ")
    void inputUtilTest() {
        String input = "//;\n1;2;3";
        assertThat(InputUtil.paresNumberList(input)).contains(1,2,3);
        String input2 = "1;2;3";
        assertThat(InputUtil.paresNumberList(input2)).contains(1,2,3);
    }

    @Test
    void checkBiggerThanZero() {
        String[] input = {"1", "5", "10"};
        List<String> numberList = Arrays.asList(input);
        assertThatThrownBy(() -> {
            InputUtil.checkBiggerThanZero(numberList);
        }).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("0보다 작은 값이 존재합니다.");
    }

    @Test
    void checkNumeric() {
        String[] input = {"1*", "5", "10"};
        List<String> numberList = Arrays.asList(input);
        assertThatThrownBy(() -> {
            InputUtil.checkNumeric(numberList);
        }).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("숫자로 변환이 불가능합니다.");
    }

    @Test
    void mapStringToInt(){
        String[] input = {"1", "2", "3", "4"};
        List<String> testList = Arrays.asList(input);
        assertThat(InputUtil.mapStringToInt(testList)).contains(1, 2, 3, 4);
    }
}
