package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @DisplayName("문자열이 Null을 검증하는 테스트")
    @Test
    void isNull_Null값() {
        // given
        String inputData = null;

        // when
        boolean actual = StringUtils.isNull(inputData);

        // then
        assertThat(actual).isTrue();
    }

    @DisplayName("문자열이 공백값인지를 검증하는 테스트")
    @Test
    void isBlank_공백값들() {
        // given
        String emptyData = "";
        String blankData = "  ";

        // when and then
        assertAll(
                () -> assertThat(StringUtils.isBlank(emptyData)).isTrue(),
                () -> assertThat(StringUtils.isBlank(blankData)).isTrue()
        );

    }

    @DisplayName("문자열이 공백 또는 널인지를 검증하는 테스트")
    @Test
    void isNullOrBlank_널과공백값들() {
        // given
        String nullData = null;
        String emptyData = "";
        String blankData = "  ";

        // when and then
        assertAll(
                () -> assertThat(StringUtils.isNullOrBlank(nullData)).isTrue(),
                () -> assertThat(StringUtils.isNullOrBlank(emptyData)).isTrue(),
                () -> assertThat(StringUtils.isNullOrBlank(blankData)).isTrue()
        );
    }


}