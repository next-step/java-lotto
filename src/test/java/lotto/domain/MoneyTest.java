package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MoneyTest {

    @Test
    @DisplayName("Money type 생성 테스트")
    void initMoneyTest() {
        assertThat(Money.initMoney(3000))
                .isInstanceOf(Money.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"3000,3", "4999,4", "999,0", "5001,5"})
    @DisplayName("로또 발행 개수")
    void lottoQuantityTest(int amount, int quantity) {
        Money money = Money.initMoney(amount);

        assertThat(money.getLottoQuantity())
                .isEqualTo(quantity);
    }

}