import domain.StringAdder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAdderTest {
    private StringAdder stringAdder = new StringAdder();

    @DisplayName("덧셈이 잘 이루어지는지 테스트")
    @Test
    void add_Test() {
        List<Integer> numbers = Arrays.asList(1,2,3);
        assertThat(stringAdder.adder(numbers)).isEqualTo(6);
    }

    @DisplayName("입력이 공백일 때 테스트")
    @Test
    void add_Blank_Test() {
        List<Integer> numbers = Arrays.asList();
        assertThat(stringAdder.adder(numbers)).isEqualTo(0);
    }
}
