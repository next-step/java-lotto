package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step1.domain.Numbers;
import java.util.List;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class NumbersTest {

    @Test
    @DisplayName("numbers 값을 전부 합한 값 return 테스트")
    void sumTest() {
        List<String> numberList = new ArrayList<String>();
        numberList.add("100");
        numberList.add("17");
        Numbers numbers = new Numbers(numberList);
        assertThat(numbers.sum()).isEqualTo(117);
    }
}
