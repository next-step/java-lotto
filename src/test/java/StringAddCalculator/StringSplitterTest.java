package StringAddCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringSplitterTest {

    @Test
    @DisplayName("(,) 로 숫자를 나눈다")
    public void split() {
         String[] numbers = StringSplitter.split("1,2,3");
         assertThat(numbers).containsExactly("1", "2", "3");
    }
}
