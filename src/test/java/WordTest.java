import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

public class WordTest {

    @DisplayName("입력한 값을 반환한다.")
    @Test
    public void makeNumbersTest() {
        String input = "1,2";
        List<String> numbers = new Word().makeNumbers(input);
        assertThat(numbers.get(0)).isEqualTo("1");
        assertThat(numbers.get(1)).isEqualTo("2");
    }

    @DisplayName("구분자를 기준으로 분리한 모든 값을 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2", "1:2"})
    public void makeNumbersTest2(String input) {
        List<String> numbers = new Word().makeNumbers(input);
        assertThat(numbers.get(0)).isEqualTo("1");
        assertThat(numbers.get(1)).isEqualTo("2");
    }

}
