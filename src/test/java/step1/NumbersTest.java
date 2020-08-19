package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Numbers")
public class NumbersTest {

    @DisplayName("하나의 숫자만 가지고 있는지")
    @Test
    public void hasOneNumber() {
        Numbers numbers = new Numbers(new String[] { "1" });
        assertThat(numbers.hasOneNumber()).isTrue();
    }

    @DisplayName("첫번째 숫자를 int 로 반환")
    @Test
    public void pickFirstValueIfHasOneNumber() {
        Numbers numbers = new Numbers(new String[] { "1" });
        assertThat(numbers.pickFirstValueIfHasOneNumber()).isEqualTo(1);
    }

    @DisplayName("숫자를 모두 더한다.")
    @Test
    public void plusNumbers() {
        Numbers numbers = new Numbers(new String[] { "1", "2", "3" });
        assertThat(numbers.sum()).isEqualTo(6);
    }

}
