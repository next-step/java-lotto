package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ExpressionParserTest {

    @DisplayName("콜론을 구분자가 포함된 표현식 파싱")
    @Test
    void parseWithColon() {

        NumberElements elements = ExpressionParser.parse("1:2");

        assertThat(elements.size()).isEqualTo(2);
    }
}
