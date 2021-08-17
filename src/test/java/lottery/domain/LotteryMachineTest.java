package lottery.domain;

import lottery.domain.createstrategy.ManualCreatingLotteryStrategy;
import lottery.domain.createstrategy.RandomCreatingLotteryStrategy;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class LotteryMachineTest {

    @ParameterizedTest(name = "getLotteries 테스트 - money 입력 | {arguments}")
    @CsvSource(value = {"2500|2", "9900|9", "1000|1"}, delimiter = '|')
    public void getLotteriesByMoney(int moneyNumber, int expectedSize) {
        // given
        LotteryMachine lotteryMachine = new LotteryMachine(new Money(moneyNumber));

        // when
        List<Lottery> lotteries = lotteryMachine.createLotteries(new RandomCreatingLotteryStrategy());

        // then
        assertThat(lotteries).isNotNull();
        assertThat(lotteries.size()).isEqualTo(expectedSize);
    }

    @Test
    @DisplayName("getLotteries 테스트 - String 리스트 입력")
    public void getLotteriesByStrings() {
        // given
        List<String> numbers = Arrays.asList("1, 2, 3, 4, 5, 6", "7, 8, 9, 10, 11, 12");
        LotteryMachine lotteryMachine = new LotteryMachine(new Money(3000));
        int expectedSize = 2;

        // when
        List<Lottery> lotteries = lotteryMachine.createLotteries(new ManualCreatingLotteryStrategy(numbers));

        // then
        assertThat(lotteries).isNotNull();
        assertThat(lotteries.size()).isEqualTo(expectedSize);
    }

    @Test
    @DisplayName("validateQuantityAndGet 테스트 - 넣은 돈보다 요구하는 수량이 많은 경우")
    public void validateQuantityAndGetNotEnoughMoney() {
        // given
        Money money = new Money(3000);
        LotteryMachine lotteryMachine = new LotteryMachine(money);
        LotteryQuantity lotteryQuantity = new LotteryQuantity(5);
        String message = "요구하는 수량에 비해 돈이 부족합니다 -> " + money + " / quantity: " + lotteryQuantity;

        // when
        ThrowingCallable throwingCallable = () -> lotteryMachine.validateQuantityAndGet(lotteryQuantity);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @Test
    @DisplayName("validateQuantityAndGet 테스트 - 정상적인 경우")
    public void validateQuantityAndGet() {
        // given
        LotteryMachine lotteryMachine = new LotteryMachine(new Money(7000));
        LotteryQuantity lotteryQuantity = new LotteryQuantity(5);
        int expected = 5;

        // when
        int quantity = lotteryMachine.validateQuantityAndGet(lotteryQuantity);

        // then
        assertThat(quantity).isEqualTo(expected);
    }
}