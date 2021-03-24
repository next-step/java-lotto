package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class SplitUtilTest {

    @Test
    @DisplayName("\",\"을 기준으로 문자열 분리")
    public void split() throws Exception {
        List<String> numbers = SplitUtil.split("1,2,3,4,5,6");
        assertThat(numbers).containsExactly("1", "2", "3", "4", "5", "6");
    }

    @Test
    @DisplayName("\",\"가 없을 시 예외")
    public void checkDelimiter() throws Exception {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> SplitUtil.split("1:2:3:4:5:6"))
                .withMessageContaining("구분자가 \",\"인지 확인");
    }

    @Test
    @DisplayName("\",\"가 5개가 아닐 시 예외")
    public void checkNumberOfDelimiter() throws Exception {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> SplitUtil.split("1,2,3,4,5:6"))
                .withMessageContaining("5개");
    }
}