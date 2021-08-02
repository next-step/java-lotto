package edu.nextstep.lotto.step2.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoListTest {

    private static LottoList lottoList;

    @BeforeAll
    static void create_before_all() {
        lottoList = new LottoList(14000);
    }

    @Test
    void create() {
        assertThat(lottoList.getLottoList().size()).isEqualTo(14);
    }

    @Test
    void match_result() {
        WinningList winningList = new WinningList("1,2,3,4,5,6");
        assertThat(lottoList.getMatchResult(winningList, 3)).isGreaterThanOrEqualTo(0);
    }

    @Test
    void rate() {
        WinningList winningList = new WinningList("1,2,3,4,5,6");
        assertThat(lottoList.getRate(winningList, 14000)).isGreaterThanOrEqualTo(0);
    }
}