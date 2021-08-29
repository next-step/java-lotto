package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class StringUtilTest {

    @DisplayName("콤마를 포함한 String 값이 들어올 경우 콤마 기준으로 split")
    @Test
    void split_ReturnSplitStringValues_IfInputContainsComma() {
        String playerNames = "jenny,jisu,risa,rose";
        String[] splitPlayerNames = StringUtil.split(playerNames);
        assertThat(splitPlayerNames).containsExactly(playerNames.split(","));
    }

    @DisplayName("input이 null 또는 empty인 경우 IllegalArgumentException 발생")
    @ParameterizedTest(name = "{index}. {displayName}, arguments: {arguments}")
    @NullAndEmptySource
    void split_ThrowsIllegalArgumentException_IfInputIsNullOrEmpty(String input) {
        assertThatIllegalArgumentException().isThrownBy(
                () -> StringUtil.split(input)
        );
    }
}