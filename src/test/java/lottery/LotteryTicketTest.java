package lottery;

import lottery.domain.LotteryNumber;
import lottery.domain.LotteryTicket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LotteryTicketTest {

    private List<LotteryNumber> lotteryNumberList;

    @BeforeEach
    public void resetLotteryNumberList() {
        lotteryNumberList = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            lotteryNumberList.add(LotteryNumber.from(i));
        }
    }

    @DisplayName("LotteryTicket 객체 정상 생성 테스트")
    @Test
    public void makeLotteryTicket() {
        LotteryTicket lotteryTicket = LotteryTicket.from(lotteryNumberList);
        assertThat(lotteryTicket.getLotteryNumbers())
                .isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("LotteryTicket 객체 생성 실패(개수 예외)")
    @Test
    public void throwExceptionOnMakingLotteryTicket() {
        lotteryNumberList.remove(0);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    LotteryTicket.from(lotteryNumberList);
                });
    }

    @DisplayName("LotteryTicket 객체 생성 실패(중복된 번호)")
    @Test
    public void throwDuplicatedExceptionOnMakingLotteryTicket() {
        lotteryNumberList.remove(0);
        lotteryNumberList.add(LotteryNumber.from(2));

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    LotteryTicket.from(lotteryNumberList);
                });
    }
}
