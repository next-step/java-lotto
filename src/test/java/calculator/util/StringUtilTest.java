package calculator.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

class StringUtilTest {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "  "})
    void isEmpty는_빈문자열_또는_null에_대해_true를_반환한다(String input) {
        assertThat(StringUtil.isEmpty(input)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "1", "가"})
    void isEmpty는_빈문자열_또는_null이_아니면_false를_반환한다(String input) {
        assertThat(StringUtil.isEmpty(input)).isFalse();
    }

    @Test
    @DisplayName("isEmpty는 빈 배열, null, 전체 원소가 null인 배열을 받을 경우 true를 반환한다.")
    void isEmpty가_배열을_받을_경우() {
        String[] emptyArray = {};
        String[] nullArray = null;
        String[] nullElementArray = {null, null, null};

        String[] normalArray = {"this", "contains", "normal"};
        String[] nullContainingArray = {"this", "contains", null};
        String[] emptyStringArray = {"", "", ""};

        assertSoftly(softly -> {
            softly.assertThat(StringUtil.isEmpty(emptyArray)).isTrue();
            softly.assertThat(StringUtil.isEmpty(nullArray)).isTrue();
            softly.assertThat(StringUtil.isEmpty(nullElementArray)).isTrue();

            softly.assertThat(StringUtil.isEmpty(normalArray)).isFalse();
            softly.assertThat(StringUtil.isEmpty(nullContainingArray)).isFalse();
            softly.assertThat(StringUtil.isEmpty(emptyStringArray)).isFalse();
        });
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"a", "가", " ", " 1", "2 ", " 3 ", "4 5"})
    void toInt는_정확한_숫자만_처리할_수_있다(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> StringUtil.toInt(input))
                .withMessage("숫자를 입력해 주세요.");
    }
}