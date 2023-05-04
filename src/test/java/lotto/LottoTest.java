package lotto;

import lotto.model.LotteryNumber;
import lotto.model.LotteryTicket;
import lotto.model.LotteryTickets;
import lotto.model.Win;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @Test
    void 금액을_입력하면_로또티켓목록을_생성() {
        int money = 14000;
        LotteryTickets lotteryTickets = new LotteryTickets(money);
        assertThat(lotteryTickets.size()).isEqualTo(14);
    }

    @Test
    void 금액이_나누어떨어지지_않으면_버림() {
        int money = 14500;
        LotteryTickets lotteryTickets = new LotteryTickets(money);
        assertThat(lotteryTickets.size()).isEqualTo(14);
    }

    @Test
    void 로또_티켓은_여섯개의_랜덤숫자를_포함() {
        LotteryTicket lotteryTicket = new LotteryTicket();
        assertThat(lotteryTicket.size()).isEqualTo(6);
    }

    @Test
    void 로또_티켓은_중복번호를_가지지않음() {
        // TODO: 랜덤으로 생성된 로또 티켓이 중복 숫자를 갖지 않는지 확인할 방법?
        assertThatThrownBy(() -> new LotteryTicket(List.of(
                new LotteryNumber(() -> 8),
                new LotteryNumber(() -> 21),
                new LotteryNumber(() -> 21),
                new LotteryNumber(() -> 41),
                new LotteryNumber(() -> 42),
                new LotteryNumber(() -> 43))))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("잘못된 로또 번호 목록입니다.");
    }

    @Test
    void 로또티켓_맞는갯수_계산() {
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

    @Test
    void 총_당첨_금액() {
        Map<Win, Integer> winTotal = new EnumMap<>(Win.class);
        winTotal.put(Win.WIN_3, 3);
        winTotal.put(Win.WIN_4, 4);
        winTotal.put(Win.WIN_5, 0);
        winTotal.put(Win.WIN_6, 1);
        assertThat(Win.totalMoney(winTotal)).isEqualTo(2000215000);
    }

}
