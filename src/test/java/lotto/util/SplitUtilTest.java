package lotto.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class SplitUtilTest {
    @Test
    void 문자열을_쉼표구분_숫자배열반환한다() {
        int[] numbers = SplitUtil.stringToNumbers("1 , 2 , 3 , 4 , 5 , 6");
        int[] expected = new int[]{1, 2, 3, 4, 5, 6};
        Assertions.assertThat(numbers).isEqualTo(expected);
    }
}
