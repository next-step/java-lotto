package lottery;

import casino.Casino;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LotteryTest {
    @DisplayName("로또는 번호는 1 - 45 까지다.")
    @Test
    void numbers() {
        Lottery lottery = new Lottery();
        int[] sample = IntStream.rangeClosed(1, 45).toArray();
        assertThat(lottery.getLotteryRange()).isEqualTo(sample);
    }

    @DisplayName("발급된 로또 번호는 1~45 사이의 값 중 6개 이다.")
    @Test
    void publicTicket() {
        Lottery lottery = new Lottery();
        List<Integer> lottoNumber = lottery.getLotteryNumbers();
        assertThat(lottoNumber.size()).isEqualTo(6);
        lottoNumber.forEach(i -> assertThat(i).isBetween(1, 45));
    }

    @DisplayName("카지노에서 로또를 살 수 있다.")
    @Test
    void buyLottery() {
        Casino casino = new Casino();
        Lottery lottery = casino.buyLottery2();
        assertThat(lottery).isInstanceOfAny(Lottery.class);
    }

    @DisplayName("카지노에서 로또는 1장에 1000원이다.")
    @ParameterizedTest
    @CsvSource(value = {"3500,3", "5000,5", "14000,14"})
    void buyLottery2(int money, int count) {
        Casino casino = new Casino();
        List<Lottery> lotteryTickets = casino.buyLottery(money);
        assertThat(lotteryTickets.size()).isEqualTo(count);
    }

    @DisplayName("카지노에서 로또를 1000원 미만의 돈으로 사면 에러를 낸다.")
    @ParameterizedTest
    @ValueSource(strings = {"900"})
    void buyLottery2(int money) {
        Casino casino = new Casino();
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> casino.buyLottery(money));
    }
}
