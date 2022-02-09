package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class ParserTest {

    @Test
    void 띄어쓰기_쉼표_파싱() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(list).isEqualTo(Parser.splitInput("1, 2, 3, 4, 5, 6"));
    }

    @Test
    void 띄어쓰기_쉼표_랜덤_파싱() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(list).isEqualTo(Parser.splitInput("1, 2, 3,4,5, 6"));
    }
}
