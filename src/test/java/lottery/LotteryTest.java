package lottery;

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
        assertThat(lottery.getLottoNumber()).isEqualTo(sample);
    }

    @DisplayName("발급된 로또 번호는 1~45 사이의 값 중 6개 이다.")
    @Test
    void getTicket2() {
        Lottery lottery = new Lottery();
        List<Integer> lottoNumber = lottery.publishLottery();
        assertThat(lottoNumber.size()).isEqualTo(6);
        lottoNumber.forEach(i -> assertThat(i).isBetween(1, 45));
    }
}
