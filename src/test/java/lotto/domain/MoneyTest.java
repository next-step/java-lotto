package lotto.domain;

import lotto.exception.InvalidLottoPurchaseAmountException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    private Money money;

    @BeforeEach
    void setMoney() {
        money = new Money(5000);
    }

    @ParameterizedTest
    @DisplayName("Money 생성 예외 테스트")
    @ValueSource(ints = {-100, 0, 100})
    void createMoney(int money) {
        assertThrows(InvalidLottoPurchaseAmountException.class, () -> new Money(money));
    }

    @Test
    @DisplayName("구매한 로또 개수 카운트 테스트")
    void lottoCount() {
        int actual = money.getLottoCount();
        int expected = 5;
        assertThat(actual).isEqualTo(expected);
    }
}