package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PreConditionUtilTest {

    @Test
    @DisplayName("null 또는 빈 값일 경우 예외")
    public void isNullOrEmpty() throws Exception {
        assertThatIllegalArgumentException().isThrownBy(() -> PreConditionUtil.isNullOrEmpty(null));
        assertThatIllegalArgumentException().isThrownBy(() -> PreConditionUtil.isNullOrEmpty(""));
    }
}