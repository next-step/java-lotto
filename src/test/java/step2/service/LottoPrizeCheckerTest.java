package step2.service;

import org.junit.jupiter.api.Test;
import step2.domain.entity.Lotto;
import step2.domain.entity.LottoTicket;
import step2.domain.vo.LottoPrize;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoPrizeCheckerTest {

    @Test
    void 당첨번호와_로또번호가_6개_일치하면_1등당첨() {
        final var lotto = new Lotto(1, 2, 3, 4, 5, 6);
        final var winner = new Lotto(1, 2, 3, 4, 5, 6);
        final var ticket = new LottoTicket(lotto);

        LottoPrizeChecker.checker(List.of(ticket), winner);

        assertThat(ticket.getLottoPrize()).isEqualTo(LottoPrize.FIRST);
    }

    @Test
    void 당첨번호와_로또번호가_5개_일치하면_2등당첨() {
        final var lotto = new Lotto(1, 2, 3, 4, 5, 6);
        final var winner = new Lotto(1, 2, 3, 4, 5, 7);
        final var ticket = new LottoTicket(lotto);

        LottoPrizeChecker.checker(List.of(ticket), winner);

        assertThat(ticket.getLottoPrize()).isEqualTo(LottoPrize.SECOND);
    }

    @Test
    void 당첨번호와_로또번호가_4개_일치하면_3등당첨() {
        final var lotto = new Lotto(1, 2, 3, 4, 5, 6);
        final var winner = new Lotto(1, 2, 3, 4, 7, 8);
        final var ticket = new LottoTicket(lotto);

        LottoPrizeChecker.checker(List.of(ticket), winner);

        assertThat(ticket.getLottoPrize()).isEqualTo(LottoPrize.THIRD);
    }

    @Test
    void 당첨번호와_로또번호가_3개_일치하면_4등당첨() {
        final var lotto = new Lotto(1, 2, 3, 4, 5, 6);
        final var winner = new Lotto(1, 2, 3, 7, 8, 9);
        final var ticket = new LottoTicket(lotto);

        LottoPrizeChecker.checker(List.of(ticket), winner);

        assertThat(ticket.getLottoPrize()).isEqualTo(LottoPrize.FOURTH);
    }

}