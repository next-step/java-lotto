package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {
    @ParameterizedTest
    @DisplayName("구매값 입력 성공 테스트")
    @ValueSource(ints = {1000, 2000, 3000})
    void 로또_구매값_입력_테스트(int purchaseAmount) {
        Money money = new Money(purchaseAmount);
        assertThat(money.getPurchaseMoney()).isEqualTo(purchaseAmount);
        assertThat(money.getYield()).isEqualTo(0);
    }

    @Test
    @DisplayName("구매값 입력 실패 테스트")
    void 로또_900원_구매_실패_테스트() {
        assertThatThrownBy(() -> new Money(900))
                .isInstanceOf(RuntimeException.class);
    }
}
