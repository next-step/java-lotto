package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LotteryTicketTest {

    @Test
    void 로또_티켓은_여섯개의_랜덤숫자를_포함() {
        LotteryTicket lotteryTicket = LotteryTicket.of(new AutoLotteryNumberGenerator());

        assertThat(lotteryTicket.size()).isEqualTo(6);
    }

    @Test
    void 로또_티켓은_중복번호를_가지지않음() {
        assertThatThrownBy(() -> new LotteryTicket(Set.of(
                LotteryNumber.of(8),
                LotteryNumber.of(21),
                LotteryNumber.of(21),
                LotteryNumber.of(41),
                LotteryNumber.of(42),
                LotteryNumber.of(43))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("duplicate element: 21");
    }

    @Test
    void 로또티켓_맞는갯수_계산() {
        LotteryTicket lotteryTicket = new LotteryTicket(Set.of(
                LotteryNumber.of(8),
                LotteryNumber.of(21),
                LotteryNumber.of(23),
                LotteryNumber.of(41),
                LotteryNumber.of(42),
                LotteryNumber.of(43)));
        Set<Integer> winNumbers = Set.of(41, 1, 13, 27, 42, 43);

        double count = lotteryTicket.matchCount(new WinNumbers(winNumbers));
        assertThat(count).isEqualTo(3);
    }

    @Test
    void 다섯개와_보너스볼_일치는_이등() {
        LotteryTicket lotteryTicket = new LotteryTicket(Set.of(
                LotteryNumber.of(27),
                LotteryNumber.of(1),
                LotteryNumber.of(10),
                LotteryNumber.of(41),
                LotteryNumber.of(42),
                LotteryNumber.of(43)));
        WinNumbers winNumbers = new WinNumbers(Set.of(41, 1, 13, 27, 42, 43), 10);

        assertThat(lotteryTicket.matchCount(winNumbers)).isEqualTo(5.5);
    }

    @Test
    void toString_정렬() {
        LotteryTicket lotteryTicket = new LotteryTicket(Set.of(
                LotteryNumber.of(27),
                LotteryNumber.of(1),
                LotteryNumber.of(10),
                LotteryNumber.of(41),
                LotteryNumber.of(42),
                LotteryNumber.of(43)));

        assertThat(lotteryTicket).hasToString("[1, 10, 27, 41, 42, 43]");
    }

}
