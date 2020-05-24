package stringcalculator.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import stringcalculator.domain.BasicDelimiter;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class BasicDelimiterTest {

    @DisplayName(",과 :로 구성된 정규식 문자열을 반환한다")
    @Test
    void makeRegex() {
        assertThat(BasicDelimiter.convertToRegex()).isEqualTo(",|:");
    }
}