package lottery.domain;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class LotteryOrderTest {

    @Test
    @DisplayName("로또를 구매할 수 없는 돈이 입력된 경우")
    public void notEnoughMoney() {
        // given
        Money money = new Money(500);
        LotteryQuantity lotteryQuantity = new LotteryQuantity(1);
        String message = "로또를 구매하기에 돈이 부족합니다 -> " + money;

        // when
        ThrowingCallable throwingCallable = () -> new LotteryOrder(money, lotteryQuantity);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @Test
    @DisplayName("넣은 돈보다 요구하는 수량이 많은 경우")
    public void notEnoughQuantity() {
        // given
        Money money = new Money(2000);
        LotteryQuantity lotteryQuantity = new LotteryQuantity(3);
        String message = "요구한 수량이 너무 많습니다 -> 가능한 수량: " + money.divideFloor(Lottery.PRICE) + " / 요구한 수량: " + lotteryQuantity;

        // when
        ThrowingCallable throwingCallable = () -> new LotteryOrder(money, lotteryQuantity);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @Test
    @DisplayName("getter 테스트")
    public void createAndGet() {
        // given
        Money money = new Money(3000);
        List<String> numbers = Arrays.asList("1, 2, 3, 4, 5, 6", "7, 8, 9, 10, 11, 12");
        LotteryOrder lotteryOrder = new LotteryOrder(money, numbers);
        LotteryQuantity expectedRandomQuantity = new LotteryQuantity(1);
        int expectedManualLotteriesSize = 2;

        // when
        LotteryQuantity randomQuantity = lotteryOrder.getRandomQuantity();
        List<String> manualStringLotteries = lotteryOrder.getManualStringLotteries();

        // then
        assertThat(randomQuantity).isEqualTo(expectedRandomQuantity);
        assertThat(manualStringLotteries.size()).isEqualTo(expectedManualLotteriesSize);
    }

}