package lotto.dto;

import lotto.common.PositiveNumber;
import lotto.domain.ticket.*;
import lotto.domain.winning.LottoWinningAmount;
import lotto.domain.winning.LottoWinningResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultDtoTest {

    @Test
    @DisplayName("로또 당첨결과를 정상적으로 셋팅하는지 확인한다")
    void setLottoResult() {
        LottoTickets lottoTickets = LottoTickets.of(Arrays.asList(
                LottoTicket.of(LottoNumbers.of(Arrays.asList(1L, 2L, 3L, 14L, 15L, 16L))),
                LottoTicket.of(LottoNumbers.of(Arrays.asList(1L, 2L, 3L, 14L, 15L, 16L))),
                LottoTicket.of(LottoNumbers.of(Arrays.asList(1L, 2L, 3L, 4L, 15L, 16L))),
                LottoTicket.of(LottoNumbers.of(Arrays.asList(1L, 2L, 3L, 4L, 5L, 16L))),
                LottoTicket.of(LottoNumbers.of(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L))))
        );
        WinningLotto winningLotto = WinningLotto.of(LottoNumbers.of(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L)), LottoNumber.of(PositiveNumber.of(45)));
        LottoResultDto lottoResultDto = LottoResultDto.of(LottoWinningResult.of(lottoTickets, winningLotto), lottoTickets.count());

        LottoWinningResult lottoWinningResult = lottoResultDto.getWinningResult();
        assertThat(lottoWinningResult.getWinningCount(LottoWinningAmount.THREE_MATCH)).isEqualTo(2);
        assertThat(lottoWinningResult.getWinningCount(LottoWinningAmount.FOUR_MATCH)).isEqualTo(1);
        assertThat(lottoWinningResult.getWinningCount(LottoWinningAmount.FIVE_MATCH)).isEqualTo(1);
        assertThat(lottoWinningResult.getWinningCount(LottoWinningAmount.SIX_MATCH)).isEqualTo(1);
        assertThat(lottoResultDto.getEarningRate()).isEqualTo(400312.0);
    }
}
