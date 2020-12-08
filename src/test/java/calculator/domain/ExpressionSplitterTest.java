package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ExpressionSplitterTest {

    @DisplayName("쉼표 구분자에 따라 쪼갠다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2", "5,6,7"})
    public void split1(String expression) {
        List<String> result = ExpressionSplitter.split(expression);
        assertThat(result).isEqualTo(Arrays.asList(expression.split(Delimiter.COMMA.getType())));
    }

    @DisplayName("쉼표 또는 콜론 구분자에 따라 쪼갠다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2:3", "5:6:7"})
    public void split2(String expression) {
        List<String> result = ExpressionSplitter.split(expression);
        assertThat(result).isEqualTo(Arrays.asList(expression.split(Delimiter.joinTypes())));
    }

    @DisplayName("custom 구분자에 따라 쪼갠다.")
    @Test
    public void split3() {
        List<String> result = ExpressionSplitter.split("//;\n1;2;3");
        assertThat(result).isEqualTo(Arrays.asList("1", "2", "3"));
    }
}
