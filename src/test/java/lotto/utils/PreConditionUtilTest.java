package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PreConditionUtilTest {

    @Test
    @DisplayName("입력 값이 null 또는 빈 값일 경우 예외가 발생한다.")
    public void checkNullOrEmpty() throws Exception {
        assertThatIllegalArgumentException().isThrownBy(() -> PreConditionUtil.checkNullOrEmpty(null));
        assertThatIllegalArgumentException().isThrownBy(() -> PreConditionUtil.checkNullOrEmpty(""));
    }
}