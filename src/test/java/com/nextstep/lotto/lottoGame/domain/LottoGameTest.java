package com.nextstep.lotto.lottoGame.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGameTest {

    @Test
    void byBudget_주어진_예산만큼의_로또_생성() {
        LottoGame lotto = LottoGame.byBudget(123450);
        assertThat(lotto.getTickets().size()).isEqualTo(123);
    }

    @Test
    void result_등수별_당첨개수_계산() {
        LottoGame lotto = new LottoGame(List.of(
                new LottoTicket(List.of(1, 2, 3, 4, 5, 6)),
                new LottoTicket(List.of(3, 4, 5, 6, 7, 8))
        ));

        LottoResult result = lotto.result(List.of(1, 2, 3, 4, 5, 6), 7);
        assertThat(result.getCount(Rank.FIRST)).isEqualTo(1);
        assertThat(result.getCount(Rank.SECOND)).isEqualTo(0);
        assertThat(result.getCount(Rank.FOURTH)).isEqualTo(1);
    }
}