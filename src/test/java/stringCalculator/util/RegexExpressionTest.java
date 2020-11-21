package stringCalculator.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RegexExpressionTest {

    @Test
    void getDefaultExpression() {
        Assertions.assertThat(RegexExpression.getSplitRegex("1,2:3"))
                .isEqualTo(",|:");
    }

    @Test
    void getDefaultExpression2() {
        Assertions.assertThat(RegexExpression.getSplitRegex("1,2:3"))
                .isEqualTo(",|:");
    }

    @Test
    void getCustomExpression() {
        Assertions.assertThat(RegexExpression.getSplitRegex("//&\\n"))
                .isEqualTo("\\&");
    }

    @Test
    void getDefaultReplaceExpression() {
        Assertions.assertThat(RegexExpression.getReplaceExpression("1,2:3"))
                .isEqualTo("1,2:3");
    }

    @Test
    void getCustomReplaceExpression() {
        Assertions.assertThat(RegexExpression.getReplaceExpression("//&\\n1&2"))
                .isEqualTo("1&2");
    }

    @Test
    void getCustomReplaceExpression2() {
        Assertions.assertThat(RegexExpression.getReplaceExpression("//^\\n1^2"))
                .isEqualTo("1^2");
    }
}