import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @DisplayName("String split 테스트")
    @Test
    void split() {
        String[] data = "1,2".split(",");
        assertThat(data).contains("1");
        assertThat(data).containsExactly("1", "2");
    }

    @DisplayName("String substring 테스트")
    @Test
    void substring() {
        String data = "(1,2)";
        String result = data.substring(1, data.length()-1);
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("String charAt 테스트")
    @Test
    void charAt() {
        String data = "abc";
        assertThat(data.charAt(0)).isEqualTo('a');
        assertThat(data.charAt(2)).isEqualTo('c');
    }

    @DisplayName("String charAt 인덱스 범위 넘어갔을 때 예외 발생 테스트")
    @ParameterizedTest
    @CsvSource(value = {"-1", "3"})
    void charAt_exception(int index) {
        String data = "abc";
        assertThatThrownBy(() -> {
            data.charAt(index);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageMatching("String index out of range: [-]?\\d+");
    }
}
