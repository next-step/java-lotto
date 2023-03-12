package lottery;

import casino.Casino;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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
        Lottery lottery = casino.buyLottery();
        assertThat(lottery).isInstanceOfAny(Lottery.class);
    }
}
