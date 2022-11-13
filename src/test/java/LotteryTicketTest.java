import domain.lottery.LotteryNumber;
import domain.lottery.LotteryTicket;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LotteryTicketTest {
    @Test
    @Order(0)
    public void 당첨번호생성_복권번호_중복() {
        assertThatThrownBy(
                () -> LotteryTicket.of(Arrays.asList(
                        LotteryNumber.of(1), LotteryNumber.of(2), LotteryNumber.of(3),
                        LotteryNumber.of(3), LotteryNumber.of(5), LotteryNumber.of(7)))
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("복권번호가 중복됩니다.");
    }

    @Test
    @Order(1)
    public void 당첨번호생성_유효하지않은_복권번호_1미만() {
        assertThatThrownBy(
                () -> LotteryTicket.of(Arrays.asList(
                        LotteryNumber.of(0), LotteryNumber.of(2), LotteryNumber.of(3),
                        LotteryNumber.of(4), LotteryNumber.of(5), LotteryNumber.of(7)))
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효하지 않은 번호입니다.");
    }

    @Test
    @Order(2)
    public void 당첨번호생성_유효하지않은_복권번호_45초과() {
        assertThatThrownBy(
                () -> LotteryTicket.of(Arrays.asList(
                        LotteryNumber.of(1), LotteryNumber.of(2), LotteryNumber.of(3),
                        LotteryNumber.of(4), LotteryNumber.of(5), LotteryNumber.of(47)))
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효하지 않은 번호입니다.");
    }
}
