package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class SplitUtilTest {

    @Test
    @DisplayName("\",\"을 기준으로 문자열 분리한다.")
    public void splitByComma() throws Exception {
        List<String> numbers = SplitUtil.splitByComma("1,2,3,4,5,6");
        assertThat(numbers).containsExactly("1", "2", "3", "4", "5", "6");
    }

    @Test
    @DisplayName("\",\"가 없을 시 예외가 발생한다.")
    public void checkDelimiter() throws Exception {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> SplitUtil.splitByComma("1:2:3:4:5:6"))
                .withMessageContaining("구분자가 \",\"인지 확인");
    }
}