package lottery.domain;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class MoneyTest {

    @Test
    @DisplayName("입력 값이 null 인 경우")
    public void nullInput() {
        // given
        String money = null;
        String message = Money.NON_NULL;

        // when
        ThrowingCallable throwingCallable = () -> new Money(money);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @Test
    @DisplayName("입력 값이 숫자가 아닌 경우")
    public void notNumber() {
        // given
        String money = "$";
        String message = Money.NOT_NUMBER + money;

        // when
        ThrowingCallable throwingCallable = () -> new Money(money);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @Test
    @DisplayName("입력 값이 음수인 경우 (String 입력)")
    public void negativeNumberStringInput() {
        // given
        String money = "-1";
        String message = Money.LESS_THAN_ZERO + money;

        // when
        ThrowingCallable throwingCallable = () -> new Money(money);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @Test
    @DisplayName("입력 값이 음수인 경우 (Integer 입력)")
    public void negativeNumberIntegerInput() {
        // given
        int money = -2;
        String message = Money.LESS_THAN_ZERO + money;

        // when
        ThrowingCallable throwingCallable = () -> new Money(money);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @Test
    @DisplayName("getBuyableLotteryCount 테스트")
    public void getBuyableLotteryCount() {
        // given
        Money money = new Money(5500);
        int expectedCount = 5;

        // when
        int maxLotteryCount = money.getBuyableLotteryCount();

        // then
        assertThat(maxLotteryCount).isEqualTo(expectedCount);
    }

    @Test
    @DisplayName("getBuyableLotteryCount 테스트 - 로또를 구매할 수 없는 경우")
    public void notEnoughMoney() {
        // given
        int moneyNumber = 550;
        Money money = new Money(moneyNumber);
        String message = Money.NOT_ENOUGH_MONEY + moneyNumber;

        // when
        // when
        ThrowingCallable throwingCallable = () -> money.getBuyableLotteryCount();

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }



}