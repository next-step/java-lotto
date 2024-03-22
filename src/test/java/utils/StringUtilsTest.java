package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringUtilsTest {

    @DisplayName("removeSpace 메서드는")
    @Nested
    class Describe_removeSpace {

        @DisplayName("입력 받은 문자열이 없을 경우, IllegalArgumentException을 발생시킨다.")
        @ParameterizedTest
        @NullAndEmptySource
        void it_throws_illegalArgumentException_when_blank_input(String input) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> StringUtils.removeSpace(input));
        }

        @DisplayName("입력 받은 문자열에 공백이 있을 경우, 제거된 문자열을 반환한다.")
        @Test
        void it_returns_space_removed_string() {
            assertThat(StringUtils.removeSpace("1, 2, 3, 4"))
                    .isEqualTo("1,2,3,4");
        }
    }

}
