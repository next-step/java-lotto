package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Parser;
import org.junit.jupiter.api.Test;

class ParserTest {
    
    @Test
    void 문자열을_올바르게_숫자로_바꾸는지_확인() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(list).isEqualTo(Parser.parseWinningNumber("1, 2, 3, 4,5,6"));
    }
}
