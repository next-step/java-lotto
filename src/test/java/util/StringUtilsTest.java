package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("문자열 유틸리티 테스트")
public class StringUtilsTest {

    @DisplayName("문자열이 null 이거나 빈 값일 경우 true 를 반환한다.")
    @NullAndEmptySource
    @ParameterizedTest
    void isEmpty(String inputString) {
        assertThat(StringUtils.isEmpty(inputString)).isTrue();
    }

}
