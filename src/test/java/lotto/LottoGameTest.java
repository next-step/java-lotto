package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {
    private LottoGame lottoGame;

    @BeforeEach
    void beforeEach() {
        this.lottoGame = new LottoGame(14000);
    }

    @Test
    void 로또_1장의_가격은_1000원이다() {
        assertThat(lottoGame.getLotteryTickets()).hasSize(14);
    }

    @Test
    void 로또_티켓하나는_6개의_번호가_부여된다() {
        for (List<Integer> lotteryTicket : lottoGame.getLotteryTickets()) {
            assertThat(lotteryTicket).hasSize(6);
        }
    }

    @Test
    void 로또_티켓에_겹치는_숫자가_있으면_안된다() {
        for (List<Integer> lotteryTicket : lottoGame.getLotteryTickets()) {
            Set<Integer> set = new HashSet<>(lotteryTicket);
            assertThat(lotteryTicket).hasSize(set.size());
        }
    }

    @Test
    void 로또_티켓의_숫자는_오름차순으로_정렬되어있다() {
        for (List<Integer> lotteryTicket : lottoGame.getLotteryTickets()) {
            for (int i = 0; i < lotteryTicket.size() - 1; i++) {
                assertThat(lotteryTicket.get(i)).isLessThan(lotteryTicket.get(i + 1));
            }
        }
    }
}
