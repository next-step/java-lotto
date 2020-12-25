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
                LotteryNumber.of(1),
                LotteryNumber.of(2),
                LotteryNumber.of(3),
                LotteryNumber.of(4),
                LotteryNumber.of(5),
                LotteryNumber.of(6)
        ));
    }

    @Test
    void createWithStringNumbers() {
        LotteryTicket lotteryTicket = LotteryTicket.manual("1,2,3,4,5,6");
        assertThat(lotteryTicket).isEqualTo(LotteryTicket.manual("1,2,3,4,5,6"));
        assertThat(lotteryTicket.getLotteryNumbers()).containsSequence(lotteryNumbers);
    }

    @Test
    void isContainNumbers() {
        LotteryTicket lotteryTicket = LotteryTicket.manual("1,2,3,4,5,6");
        assertThat(lotteryTicket.contains(LotteryNumber.of(1))).isTrue();
    }

    @Test
    void isNotContainNumbers() {
        LotteryTicket lotteryTicket = LotteryTicket.manual("1,2,3,4,5,6");
        assertThat(lotteryTicket.contains(LotteryNumber.of(7))).isFalse();
    }
}
