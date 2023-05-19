package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @DisplayName("split 메서드 테스트")
    @Test
    public void splitTest() {
        String input = "1, 2, 3, 4, 5, 6";
        String delimiter = ", ";
        String[] result = input.split(delimiter);
        assertThat(result).hasSize(6);
    }
}
