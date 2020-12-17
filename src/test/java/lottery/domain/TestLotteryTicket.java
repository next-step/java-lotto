package lottery.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class TestLotteryTicket {
    List<LotteryNumber> lotteryNumbers;
    @BeforeEach
    void setUp() {
        lotteryNumbers = new ArrayList<>(Arrays.asList(
                new LotteryNumber(1),
                new LotteryNumber(2),
                new LotteryNumber(3),
                new LotteryNumber(4),
                new LotteryNumber(5),
                new LotteryNumber(6)
        ));
    }

    @Test
    void createWithStringNumbers() {
        LotteryTicket lotteryTicket = LotteryTicket.of("1,2,3,4,5,6");
        assertThat(lotteryTicket).isEqualTo(LotteryTicket.of("1,2,3,4,5,6"));
        assertThat(lotteryTicket.getLotteryNumbers()).containsSequence(lotteryNumbers);
    }

    @Test
    void isContainNumbers() {
        LotteryTicket lotteryTicket = LotteryTicket.of("1,2,3,4,5,6");
        assertThat(lotteryTicket.contains(new LotteryNumber(1))).isTrue();
    }

    @Test
    void isNotContainNumbers() {
        LotteryTicket lotteryTicket = LotteryTicket.of("1,2,3,4,5,6");
        assertThat(lotteryTicket.contains(new LotteryNumber(7))).isFalse();
    }
}
