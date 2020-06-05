package lotto.domain;

import lotto.domain.dto.ManualNumberDto;
import lotto.domain.ticket.LottoTicket;
import lotto.domain.ticket.LottoWinningTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoBillTest {
    @DisplayName("모든 로또 티켓과 당첨 번호를 비교하여 추첨 결과를 반환한다.")
    @Test
    void drawAllLotto() {
        LottoTicket ticket1 = LottoTicket.ofFixed(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoTicket ticket2 = LottoTicket.ofFixed(Arrays.asList(1, 2, 3, 4, 5, 7));
        LottoTicket ticket3 = LottoTicket.ofFixed(Arrays.asList(1, 2, 3, 4, 5, 8));

        LottoWinningTicket lottoWinningTicket = new LottoWinningTicket(new ManualNumberDto("1, 2, 3, 4, 5, 6")
                , 7);

        LottoBill lottoBill = new LottoBill(Arrays.asList(ticket1, ticket2, ticket3));

        LottoResult lottoResult = lottoBill.drawAllLotto(lottoWinningTicket);

        LottoResult expectedResult = new LottoResult(Arrays.asList(WinningSheet.FIRST, WinningSheet.SECOND
                , WinningSheet.THIRD));

        assertThat(lottoResult).isEqualToComparingFieldByField(expectedResult);
    }
}
