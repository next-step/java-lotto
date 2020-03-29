package lotto;

import lotto.domain.LottoNumbers;
import lotto.domain.LottoRank;
import lotto.domain.LottoResults;
import lotto.domain.LottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {

    @Test
    @DisplayName("로또 당첨 숫자에 따라 올바른 로또 통계 결과가 나와야 한다.")
    public void lottoResultTest() {
        LottoNumbers winningNumbers = LottoNumbers.valueOf(1,2,3,4,5,6);
        LottoTicket lottoTicket = LottoTicket.with(
                LottoNumbers.valueOf(1,2,3,4,5,6),
                LottoNumbers.valueOf(1,2,3,4,5,7),
                LottoNumbers.valueOf(6,2,3,4,5,1),
                LottoNumbers.valueOf(6,2,3,4,22,10),
                LottoNumbers.valueOf(1,2,3,14,23,24),
                LottoNumbers.valueOf(24,5,7,14,23,27)
        );

        LottoResults results = lottoTicket.collectResults(winningNumbers);

        assertThat(results.countBy(LottoRank.FIRST)).isEqualTo(2);
        assertThat(results.countBy(LottoRank.SECOND)).isEqualTo(1);
        assertThat(results.countBy(LottoRank.THIRD)).isEqualTo(1);
        assertThat(results.countBy(LottoRank.FOURTH)).isEqualTo(1);
        assertThat(results.countBy(LottoRank.FIFTH)).isEqualTo(0);
        assertThat(results.countBy(LottoRank.SIXTH)).isEqualTo(1);
        assertThat(results.countBy(LottoRank.SEVENTH)).isEqualTo(0);
    }

}
