package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step1.domain.Number;
import step1.domain.Numbers;
import step1.util.InputUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

public class InputUtilTest {

    @Test
    @DisplayName("0 보다 작은 값이 입력으로 들어올 때 RuntimeException 발생")
    void checkBiggerThanZero() {
        assertThatThrownBy(() -> {
            new Number(-1);
        }).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("0보다 작은 값이 존재합니다.");
    }

    @Test
    @DisplayName("숫자가 아닌 값이 들어올 때 RuntimeException 발생")
    void checkNumeric() {
        String[] input = {"1*", "5", "10"};
        List<String> numberList = Arrays.asList(input);
        assertThatThrownBy(() -> {
            InputUtil.checkNumeric(numberList);
        }).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("숫자로 변환이 불가능합니다.");
    }

    @Test
    @DisplayName("String 타입으로 들어온 input 을 Integer 로 mapping")
    void mapStringToInt() {
        String[] input = {"1", "2", "3", "4"};
        List<String> testList = Arrays.asList(input);
        assertThat(InputUtil.mapStringToInt(testList)).contains(1, 2, 3, 4);
    }

    @Test
    @DisplayName("Numbers 받아오는게 잘 되는지 테스트")
    void getNumbers() {
        String input = "1,2,3,4";
        List<Integer> testList = Arrays.asList(input.split(",")).stream().map(i->Integer.parseInt(i)).collect(Collectors.toList());
        Numbers numbers = InputUtil.getNumbers(input);
        for (int i =0 ; i < 4; i++) {
            System.out.println(InputUtil.getNumbers(input).getNumbers().get(i).getNum());
            assertThat(numbers.getNumbers().get(i).getNum()).isEqualTo(testList.get(i));
        }
    }

}
