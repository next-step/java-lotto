package step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LotteryResultTest {

    LotteryResult lotteryResult;
    LotteryTicket lotteryTicket;

    @BeforeEach
    void setUp() {
        lotteryResult = new LotteryResult(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @Test
    void 로또_당첨_개수_테스트() {
        List<Integer> lotteryNumbers = Arrays.asList(3, 6, 7, 8, 9, 10);
        lotteryTicket = new LotteryTicket(lotteryNumbers);
        assertThat(lotteryResult.countMatchingNum(lotteryTicket)).isEqualTo(2);
    }
}