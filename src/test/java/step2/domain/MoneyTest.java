package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.exception.IsLessThanTheMiminumAmountOfMoneyException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static step2.domain.LottoGame.MONEY_IS_LESS_THAN_1000;

public class MoneyTest {

    @Test
    @DisplayName("Money 객체 생성 테스트")
    void create() {
        Money money = new Money(2_000);
        assertThat(money).isEqualTo(new Money(2_000));
    }

    @Test
    @DisplayName("입력된 구매 금액이 1000이하인 경우 예외 테스트")
    void is_valid_range() {
        assertThatThrownBy(() -> new Money(500))
                .isInstanceOf(IsLessThanTheMiminumAmountOfMoneyException.class)
                .hasMessageContaining(MONEY_IS_LESS_THAN_1000);
    }

    @ParameterizedTest
    @DisplayName("입력받은 구입 금액 만큼 로또를 구입하는지 테스트")
    @CsvSource(value = {"14000:14", "7000:7", "5000:5"}, delimiter = ':')
    void getNumberOfLottery(int amount, int expected) {
        Money money = new Money(amount);
        assertThat(money.getNumberOfLottery())
                .isEqualTo(expected);
    }
}
