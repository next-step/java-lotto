package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("표현식")
public class NumericalExpressionTest {

    @DisplayName("split")
    @Test
    public void split() {
        NumericalExpression numericalExpression = new NumericalExpression("1");
        String[] numbers = numericalExpression.split();
        assertThat(numbers).hasSize(1);
        assertThat(numbers).contains("1");
    }

}
