package lotto;

import lotto.model.LotteryNumber;
import lotto.model.LotteryTicket;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    void 금액을_입력하면_로또리스트_생성() {
        int money = 14000;
        List<LotteryTicket> lotteryTickets = LotteryStore.sell(money);
        assertThat(lotteryTickets).hasSize(14);
    }

    @Test
    void 금액이_나누어떨어지지_않으면_버림() {
        int money = 14500;
        List<LotteryTicket> lotteryTickets = LotteryStore.sell(money);
        assertThat(lotteryTickets).hasSize(14);
    }

    @Test
    void 로또_한장에는_여섯개의_랜덤숫자() {
        LotteryTicket lotteryTicket = new LotteryTicket();
        assertThat(lotteryTicket.size()).isEqualTo(6);
    }

    @Test
    void 로또_당_맞는갯수_계산() {
        LotteryTicket lotteryTicket = new LotteryTicket(List.of(
                new LotteryNumber(() -> 8),
                new LotteryNumber(() -> 21),
                new LotteryNumber(() -> 23),
                new LotteryNumber(() -> 41),
                new LotteryNumber(() -> 42),
                new LotteryNumber(() -> 43)));
        List<Integer> winNumbers = List.of(41, 1, 13, 27, 42, 43);
        int count = lotteryTicket.compare(winNumbers);
        assertThat(count).isEqualTo(3);
    }
}
