package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoWinningTest {
    private LottoWinning result;

    @BeforeEach
    void setUp() {
        Lotto lotto1 = new Lotto("1,2,3,4,5,6");
        Lotto lotto2 = new Lotto("10,11,12,13,14,15");
        Lotto lotto3 = new Lotto("20,21,22,23,24,25");
        Lotto lotto4 = new Lotto("1,2,3,23,24,25");
        List<Lotto> lottos = new ArrayList<>(Arrays.asList(lotto1, lotto2, lotto3, lotto4));
        Lotto lastWeekTicket = new Lotto("1,2,3,4,5,6");
        LottoTicket lottoTicket = new LottoTicket(lottos);
        result = lottoTicket.result(lastWeekTicket);
    }

    @Test
    @DisplayName("지난주 당첨 로또랑 비교하여 일치하는 로또 숫의의 개수에 따라 각 로또티켓 개수를 확인한다.")
    void prizeCountTest() {
        assertThat(result.count(LottoRank.FIRST)).isEqualTo(1);
        assertThat(result.count(LottoRank.SECOND)).isEqualTo(0);
        assertThat(result.count(LottoRank.THIRD)).isEqualTo(0);
        assertThat(result.count(LottoRank.FOURTH)).isEqualTo(1);
    }

    @Test
    @DisplayName("지난주 당첨 로또랑 비교하여 당첨된 것이 있어 2000005000 금액을 받음을 확인한다.")
    void prizeMoneyTest() {
        assertThat(result.sumWinningMoney()).isEqualTo(2000005000);
    }
}
