package lotto.step2;

import lotto.step2.domain.Money;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {

    @ParameterizedTest(name = "구매 금액 범위 Test")
    @ValueSource(strings = {"0","500","950"})
    public void 구매_금액_범위_Test(String input) {
        assertThatThrownBy(() -> new Money(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구매 금액은 1000원 이상이어야 합니다.");

    }

    @ParameterizedTest(name = "구매 금액 타입 Test")
    @ValueSource(strings = {"abc","가나다","123a"})
    public void 구매_금액_타입_Test(String input) {
        assertThatThrownBy(() -> new Money(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("돈은 정수여야 합니다.");

    }


}
