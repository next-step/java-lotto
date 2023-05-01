package calculator.domain;

import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ExpressionTest {

    @Test
    void null_또는_빈_리스트로_생성시_IllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Expression(null));
        assertThatIllegalArgumentException().isThrownBy(() -> new Expression(List.of()));
    }
}
