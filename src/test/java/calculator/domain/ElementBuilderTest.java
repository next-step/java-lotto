package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ElementBuilderTest {
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    void 숫자_생성_테스트(String source) {
        assertThat(ElementBuilder.of(source)).isEqualTo(new NumberElement(source));
    }

    @Test
    void 연산자_생성_테스트() {
        assertThat(ElementBuilder.of("+")).isEqualTo(new Plus());
        assertThat(ElementBuilder.of("-")).isEqualTo(new Minus());
        assertThat(ElementBuilder.of("*")).isEqualTo(new Multiply());
        assertThat(ElementBuilder.of("/")).isEqualTo(new Division());
    }
}
