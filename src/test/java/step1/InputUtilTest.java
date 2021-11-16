package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step1.domain.Numbers;
import step1.util.InputUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

public class InputUtilTest {

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

    @Test
    @DisplayName("null 또는 빈 문자열로 input 이 들어올 때 테스트")
    void checkNull() {
        List<Integer> testList = Arrays.asList(0);
        Numbers numbers = InputUtil.getNumbers("");
        assertThat(numbers.getNumbers().get(0).getNum()).isEqualTo(testList.get(0));

        List<Integer> testList1 = Arrays.asList(0);
        Numbers numbers1 = InputUtil.getNumbers(null);
        assertThat(numbers1.getNumbers().get(0).getNum()).isEqualTo(testList1.get(0));
    }
}
