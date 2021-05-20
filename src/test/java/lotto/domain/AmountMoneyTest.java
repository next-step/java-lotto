package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AmountMoneyTest {

    @DisplayName("로또를 구입할 금액 객체 생성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1000, 5000, 10000})
    public void createAmountMoneyTest(int money) {
        AmountMoney amountMoney = AmountMoney.create(money);

        assertThat(amountMoney).isEqualTo(AmountMoney.create(money));
    }

    @DisplayName("1000원 미만의 금액 객체 생성예외 테스트")
    @ParameterizedTest
    @ValueSource(ints = {0, 500, 999})
    public void invalidAmountMoneyTest(int money) {
        assertThatThrownBy(() -> AmountMoney.create(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입가능 티켓 갯수 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1000:1", "1500:1", "3000:3", "15000:15", "25500:25"}, delimiter = ':')
    public void howManyCouldBuyTicketTest(int money, int count) {
        AmountMoney amountMoney = AmountMoney.create(money);

        assertThat(amountMoney.couldBuyTicketAmount()).isEqualTo(count);
    }
}
