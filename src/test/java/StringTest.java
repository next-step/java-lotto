import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    void splitTest() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1", "2");
        assertThat(result).containsExactly("1", "2");

    }

    @Test
    void substringTest() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("chartAt() method 활용 시 문자열 위치값을 벗어나면 StringIndexOutOfBoundsException 정상 발생 여부 테스트")
    void chatAtTest() {
        String testData = "abc";
        assertThatThrownBy(() -> testData.charAt(4))
                .isInstanceOf(IndexOutOfBoundsException.class).hasMessageContaining("index out of range: 4");

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> testData.charAt(4)).withMessageMatching("String index out of range: \\d+");
    }
}

