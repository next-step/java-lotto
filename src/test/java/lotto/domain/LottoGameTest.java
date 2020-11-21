package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LottoGameTest {

    @DisplayName("LottoGame 생성 테스트")
    @Test
    void lottoGameConstructorTest(){
        // given
        int inputMoneyAmount = 14000;

        // when
        LottoGame lottoGame = new LottoGame(inputMoneyAmount);

        // then
        assertThat(lottoGame.getGameMoney()).isEqualTo(inputMoneyAmount);
    }

    @DisplayName("LottoGame start 테스트")
    @Test
    void lottoGameStartTest(){
        // given
        int inputMoneyAmount = 14000;

        // when
        LottoGame lottoGame = new LottoGame(inputMoneyAmount);
        LottoGameResults lottoGameResults = lottoGame.issueLottoTicket();

        /*lottoGameResults.getLottoIssueResult().getLottoTickets()
                .stream().forEach(lottoTicket -> System.out.println(Arrays.toString(lottoTicket.getSortedLottoNumbers().toArray())));*/

        // then
        assertThat(lottoGameResults.getLottoIssueResult().getTicketCount()).isEqualTo(inputMoneyAmount/1000);
    }

}
