package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.SoftAssertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    @Test
    @DisplayName("1등 당첨된 티켓은 1개이고 2등 당첨된 티켓은 0개이다.")
    void getResult() {
        LottoTicket lottoTicket = new LottoTicket(List.of(1,2,3,4,5,6));
        WinnerNumber winnerNumber = new WinnerNumber(List.of(1,2,3,4,5,6));
        LottoResult lottoResult = new LottoResult();

        lottoResult.calculateRank(List.of(lottoTicket), winnerNumber, 7);

        assertSoftly(softly -> {
            assertThat(lottoResult.getResult().get(LottoRank.FIRST)).isEqualTo(1);
            assertThat(lottoResult.getResult().get(LottoRank.SECOND)).isEqualTo(0);
        });

    }

    @Test
    @DisplayName("1000원으로 구입한 로또 1등 당첨의 수익률은 2000000.0 이다 ")
    void rate() {
        LottoTicket lottoTicket = new LottoTicket(List.of(1,2,3,4,5,6));
        WinnerNumber winnerNumber = new WinnerNumber(List.of(1,2,3,4,5,6));
        LottoResult lottoResult = new LottoResult();
        lottoResult.calculateRank(List.of(lottoTicket), winnerNumber, 7);

        assertThat(lottoResult.getRate(1000)).isEqualTo(2000000.0);

    }

}