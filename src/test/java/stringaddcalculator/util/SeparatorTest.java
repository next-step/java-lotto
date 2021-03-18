package stringaddcalculator.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SeparatorTest {

    @Test
    void splitExpression_기본_구분자() {
        DefaultSeparator defaultSeparator = new DefaultSeparator();
        assertThat(defaultSeparator.splitExpression("1,2")).isEqualTo(new String[]{"1","2"});
        assertThat(defaultSeparator.splitExpression("1:2")).isEqualTo(new String[]{"1","2"});
    }

    @Test
    void splitExpression_커스텀_구분자() {
        CustomSeparator customSeparator = new CustomSeparator();
        assertThat(customSeparator.splitExpression("//!\n1!2")).isEqualTo(new String[]{"1","2"});
    }
}
