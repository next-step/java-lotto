package step2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step2.domain.Number;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class NumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void 로또_번호는_1에서_45사이이다(int value) {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> Number.of(value))
                .withMessage("1에서 45 사이의 수를 입력해주세요.");
    }
}
