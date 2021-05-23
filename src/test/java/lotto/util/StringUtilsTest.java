package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class StringUtilsTest {

    @Test
    @DisplayName("csv형식의 string을 int 배열로 변환")
    public void csvToIntArrayTest() {
        String source = "1, 2,3,4, 12  ,7";

        int[] result = StringUtils.csvToIntArray(source);

        assertThat(result.length).isEqualTo(6);
        assertThat(result).contains(1, 2, 3, 4, 12, 7);
    }

    @Test
    @DisplayName("숫자에 세자릿수 마다 콤마 표시")
    public void toMoneyFormatTest() {
        assertThat(StringUtils.toMoneyFormat(100)).isEqualTo("100");
        assertThat(StringUtils.toMoneyFormat(1000)).isEqualTo("1,000");
        assertThat(StringUtils.toMoneyFormat(1000000)).isEqualTo("1,000,000");
        assertThat(StringUtils.toMoneyFormat(1000000000)).isEqualTo("1,000,000,000");
    }
}