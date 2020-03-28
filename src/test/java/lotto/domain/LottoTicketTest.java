package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTest {

    @DisplayName("로또 번호로 로또 번호들을 만들 수 있다.")
    @Test
    public void newLottoNumberInstanceTest() {
        LottoNumber game1 = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumber game2 = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6));

        LottoTickets boughtTickets = new LottoTickets(game1, game2);

        assertThat(boughtTickets.size()).isEqualTo(2);
    }

    @DisplayName("당첨 번호를 입력하면 각 로또 번호중 일치하는 번호의 개수를 반환한다.")
    @Test
    public void returnMatchedNumberCountTest() {
        LottoNumber game1 = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumber game2 = new LottoNumber(Arrays.asList(7, 8, 9, 10, 11, 12));
        LottoTickets boughtTickets = new LottoTickets(game1, game2);

        WinningNumber winningNumber = new WinningNumber(Arrays.asList(5, 6, 7, 8, 9, 10), 11);
        List<LottoRank> lottoGameResult = boughtTickets.checkRank(winningNumber);

        assertThat(lottoGameResult).hasSize(2);
        assertThat(lottoGameResult.get(0).getMatchCount()).isEqualTo(2);
        assertThat(lottoGameResult.get(1).getMatchCount()).isEqualTo(4);
    }

}
