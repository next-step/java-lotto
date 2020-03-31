package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {

    @Test
    @DisplayName("로또 당첨 숫자에 따라 올바른 로또 통계 결과가 나와야 한다.")
    public void lottoResultTest() {
        LottoNumbers winningNumbers = LottoNumbers.valueOf(1, 2, 3, 4, 5, 6);
        LottoNumber bonusNumber = LottoNumber.valueOf(8);

        LottoTicket lottoTicket = LottoTicket.with(
                LottoNumbers.valueOf(1, 2, 3, 4, 5, 6), // 1
                LottoNumbers.valueOf(1, 2, 3, 4, 5, 8), // 2
                LottoNumbers.valueOf(1, 2, 3, 4, 5, 7), // 3
                LottoNumbers.valueOf(6, 2, 3, 4, 5, 1), // 1
                LottoNumbers.valueOf(6, 2, 3, 4, 22, 10), // 4
                LottoNumbers.valueOf(1, 2, 3, 14, 23, 24), // 5
                LottoNumbers.valueOf(24, 5, 7, 14, 23, 27) // MISS
        );

        LottoResults results = lottoTicket.collectResults(winningNumbers, bonusNumber);

        assertThat(results.countBy(LottoRank.FIRST)).isEqualTo(2);
        assertThat(results.countBy(LottoRank.SECOND)).isEqualTo(1);
        assertThat(results.countBy(LottoRank.THIRD)).isEqualTo(1);
        assertThat(results.countBy(LottoRank.FOURTH)).isEqualTo(1);
        assertThat(results.countBy(LottoRank.FIFTH)).isEqualTo(1);
        assertThat(results.countBy(LottoRank.MISS)).isEqualTo(1);
    }

}
