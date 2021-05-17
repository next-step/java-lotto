package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilsTest {

    @DisplayName("1,2 를 ,로 split 했을때 잘 분리되는지 확인")
    @Test
    public void splitStringTest1() {
        String input = "1,2";

        String[] splitStrings = StringUtils.split(input);

        assertThat(splitStrings).contains("1", "2");
        assertThat(splitStrings).hasSize(2);
    }

    @DisplayName("1 를 ,로 split 했을때 1만 포함하는 배열인지 확인")
    @Test
    public void splitStringTest2() {
        String input = "1";

        String[] splitStrings = StringUtils.split(input);

        assertThat(splitStrings).containsExactly("1");
        assertThat(splitStrings).hasSize(1);
    }
}
