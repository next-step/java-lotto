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
        String message = "입력값은 null 일 수 없습니다";

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
        String message = "숫자가 아닙니다 -> " + money;

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
        String message = "입력값은 0 보다 커야 합니다 -> " + money;

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
        String message = "입력값은 0 보다 커야 합니다 -> " + money;

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
        LotteryQuantity buyableLotteryCount = money.getBuyableLotteryQuantity();

        // then
        assertThat(buyableLotteryCount.intStream().count()).isEqualTo(expectedCount);
    }

    @Test
    @DisplayName("getBuyableLotteryCount 테스트 - 로또를 구매할 수 없는 경우")
    public void notEnoughMoney() {
        // given
        int moneyNumber = 550;
        Money money = new Money(moneyNumber);
        String message = "로또를 구매하기에 돈이 부족합니다 -> " + moneyNumber;

        // when
        // when
        ThrowingCallable throwingCallable = () -> money.getBuyableLotteryQuantity();

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @Test
    @DisplayName("buyLotteries 테스트 - 돈이 수량보다 부족한 경우")
    public void buyLotteriesNotEnoughMoney() {
        // given
        Money money = new Money(3000);
        LotteryQuantity lotteryQuantity = new LotteryQuantity(5);
        String message = "로또를 구매하기에 돈이 부족합니다 -> " + money + " / quantity: " + lotteryQuantity;

        // when
        ThrowingCallable throwingCallable = () -> money.buyLotteries(lotteryQuantity);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @Test
    @DisplayName("buyLotteries 테스트 - 구매 가능 경우")
    public void buyLotteries() {
        // given
        Money money = new Money(5000);
        LotteryQuantity lotteryQuantity = new LotteryQuantity(2);
        Money restMoney = new Money(3000);

        // when
        money.buyLotteries(lotteryQuantity);

        // then
        assertThat(money).isEqualTo(restMoney);
    }

}