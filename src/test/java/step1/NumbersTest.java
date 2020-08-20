package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Numbers")
public class NumbersTest {

    @DisplayName("숫자를 모두 더한다.")
    @Test
    public void plusNumbers() {
        Numbers numbers = new Numbers(new String[] { "1", "2", "3" });
        assertThat(numbers.sum()).isEqualTo(6);
    }

}
