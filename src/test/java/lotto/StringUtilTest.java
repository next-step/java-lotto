package lotto;

import lotto.util.StringUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilTest {

    @Test
    @DisplayName("문자열을 , 기준으로 분리한다.")
    void split() {
        String[] actual = StringUtil.split("1,2,3,4,5,6");
        String[] expected = {"1","2","3","4","5","6"};
        assertThat(actual).isEqualTo(expected);
    }

}