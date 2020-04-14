package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class MannualCountTest {

    private static final int ONE_LOTTO_PRICE = 1000;
    private static final int TWO_LOTTO_COUNTS = 2;

    @DisplayName("가진 돈의 양보다 수동 구매 갯수를 초과하는지 테스트")
    @Test
    void testOverBudget() {
        Money money = new Money(ONE_LOTTO_PRICE);
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new MannualCount(money, TWO_LOTTO_COUNTS));
    }
}
