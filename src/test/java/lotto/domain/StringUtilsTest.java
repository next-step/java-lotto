package lotto;

import lotto.utils.StringUtils;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilsTest {
    @Test
    void split() {
        String input = "1,2,3,4,5,6";
        String[] textWinNumbers = StringUtils.splitTextWinNumbers(input);
        assertThat(textWinNumbers).containsExactly("1", "2", "3", "4", "5", "6");
    }

    @Test
    void 정수_변환() {
        List<Integer> winNumbers = StringUtils.parseWinNumbers("1,2,3,4,5,6");
        assertThat(winNumbers).containsExactly(1, 2, 3, 4, 5, 6);
    }
}
