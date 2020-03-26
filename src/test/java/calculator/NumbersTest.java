package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumbersTest {

    @DisplayName("Numbers 객체 생성을 할 수 있다.")
    @Test
    void create() {
        String[] splitedString = new String[]{"1", "2"};
        Numbers expect = new Numbers(splitedString);

        Numbers actual = new Numbers(splitedString);

        assertThat(actual).isEqualTo(expect);
    }
}
