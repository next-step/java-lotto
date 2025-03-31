package utils;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class SplitterTest {
    @Test
    void 문자열을_쉼표로_split_후_정수_리스트로_변환() {
        String input = "1, 2, 3, 4, 5, 6";

        List<Integer> result = Splitter.splitAndConvertInt(input);

        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    void 공백이_포함되어도_정상적으로_파싱() {
        String input = "10,20,   30,40";

        List<Integer> result = Splitter.splitAndConvertInt(input);

        assertThat(result).containsExactly(10, 20, 30, 40);
    }

    @Test
    void 숫자가_아닌값이_포함되면_예외() {
        String input = "1, 2, three, 4";

        assertThatThrownBy(() -> Splitter.splitAndConvertInt(input))
            .isInstanceOf(NumberFormatException.class);
    }

}
