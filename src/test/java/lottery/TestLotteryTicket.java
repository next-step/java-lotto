package lottery;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class TestLotteryTicket {
    @Test
    @DisplayName("로또 넘버 입력받아서 로또 티켓을 생성합니다.")
    void createLotteryTicket() {
        LotteryTicket lotteryTicket = new LotteryTicket(Arrays.asList(
                new LotteryNumber(1),
                new LotteryNumber(2),
                new LotteryNumber(3),
                new LotteryNumber(4),
                new LotteryNumber(5),
                new LotteryNumber(6)
        ));
        assertThat(lotteryTicket).isEqualTo(new LotteryTicket(Arrays.asList(
                new LotteryNumber(1),
                new LotteryNumber(2),
                new LotteryNumber(3),
                new LotteryNumber(4),
                new LotteryNumber(5),
                new LotteryNumber(6)
        )));
    }

    @Test
    @DisplayName("숫자를 입력받아 로또 티켓을 생성합니다.")
    void createWithLotteryNumbers() {
        LotteryTicket lotteryTicket = new LotteryTicket(new int[]{1, 2, 3, 4, 5, 6});
        assertThat(lotteryTicket).isEqualTo(new LotteryTicket(new int[]{1, 2, 3, 4, 5, 6}));
    }
}
