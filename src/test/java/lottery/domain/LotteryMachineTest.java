package lottery.domain;

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

    @Test
    @DisplayName("로또를 구매할 수 없는 돈이 입력된 경우")
    public void notEnoughMoney() {
        // given
        Money money = new Money(500);
        String message = "로또를 구매하기에 돈이 부족합니다 -> " + money;

        // when
        ThrowingCallable throwingCallable = () -> new LotteryMachine(money);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @Test
    @DisplayName("넣은 돈보다 요구하는 수량이 많은 경우")
    public void notEnoughQuantity() {
        // given
        Money money = new Money(3000);
        LotteryQuantity lotteryQuantity = new LotteryQuantity(5);
        String message = "요구한 수량이 너무 많습니다 -> 가능한 수량: " + money.divideFloor(Lottery.PRICE) + " / 요구한 수량: " + lotteryQuantity;

        // when
        ThrowingCallable throwingCallable = () -> new LotteryMachine(money, lotteryQuantity);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @ParameterizedTest(name = "createLotteries 테스트 - money 입력 | {arguments}")
    @CsvSource(value = {"2500|2", "9900|9", "1000|1"}, delimiter = '|')
    public void createLotteriesByMoney(int moneyNumber, int expectedSize) {
        // given
        LotteryMachine lotteryMachine = new LotteryMachine(new Money(moneyNumber));

        // when
        Lotteries lotteries = lotteryMachine.createLotteries();

        // then
        assertThat(lotteries).isNotNull();
        assertThat(lotteries.toDto().size()).isEqualTo(expectedSize);
    }

    @Test
    @DisplayName("createLotteries 테스트 - String 리스트 입력")
    public void createLotteriesByStrings() {
        // given
        List<String> numbers = Arrays.asList("1, 2, 3, 4, 5, 6", "7, 8, 9, 10, 11, 12");
        LotteryQuantity lotteryQuantity = new LotteryQuantity(2);
        LotteryMachine lotteryMachine = new LotteryMachine(new Money(3000), lotteryQuantity);
        int expectedSize = 3;

        // when
        Lotteries lotteries = lotteryMachine.createLotteries(numbers);

        // then
        assertThat(lotteries).isNotNull();
        assertThat(lotteries.toDto().size()).isEqualTo(expectedSize);
    }

}