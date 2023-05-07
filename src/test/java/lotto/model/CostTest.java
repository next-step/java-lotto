package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CostTest {

    @DisplayName("구입 비용 테스트(0이상 입력)")
    @ParameterizedTest
    @ValueSource(ints = {0, 1000, 3000})
    void 로또_구입비용_0원이상(int input) {
        assertTrue(new Cost(input).getMoney() >= 0);
    }

    @DisplayName("구입 비용 테스트(음수값 입력)")
    @ParameterizedTest
    @ValueSource(ints = {-1, -1000, -3000})
    void 로또_구입비용_음수(int input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Cost(input))
                .withMessageMatching("구입 금액은 음수일 수 없습니다.");
    }

}
