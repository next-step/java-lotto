package stringcalculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DelimiterTest {

    @ValueSource(strings = {"//;\n1;2;3", "//-\n1-2-3-4"})
    @ParameterizedTest
    void 커스텀_구분자가_있을_경우_이를_제외하고_식부분만_검출한다(final String given) {
        assertThat(Delimiter.findExpression(given)).isEqualTo(given.substring(4));
    }

    @Test
    void 구분자를_제외하고_숫자리스트만_추출한다() {
        String given = "1,2,3";
        List<Integer> extracted = Delimiter.extractNumberFromExpression(given);
        assertThat(extracted).isEqualTo(Arrays.asList(1, 2, 3));
    }

}