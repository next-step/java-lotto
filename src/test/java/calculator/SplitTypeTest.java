package calculator;

import calculator.exception.NotFoundSplitTypeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SplitTypeTest {

    @DisplayName("해당하는 구분자가 있을 경우 SplitNumber 인스턴스를 리턴받는다")
    @ParameterizedTest
    @ValueSource(strings = {"1,2:3", "10", "//;\n1;2;3"})
    void split(String str) {
        assertThat(SplitType.split(str)).isInstanceOf(SplitNumber.class);
    }

    @DisplayName("해당하는 구분자가 없을 경우 NotFoundSplitTypeException 이 발생한다.")
    @Test
    void not_found_split_type() {
        assertThatThrownBy(() -> SplitType.split("!2!3"))
                .isInstanceOf(NotFoundSplitTypeException.class);
    }
}