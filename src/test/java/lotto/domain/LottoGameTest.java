package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


public class LottoGameTest {

    @DisplayName("LottoGame 생성 테스트")
    @Test
    void lottoGameConstructorTest(){
        // given
        int inputMoneyAmount = 14000;

        // when
        LottoGame lottoGame = new LottoGame(inputMoneyAmount, new ArrayList<>());

        // then
        assertThat(lottoGame.getGameMoney()).isEqualTo(inputMoneyAmount);
    }

    @DisplayName("LottoGame start 테스트")
    @Test
    void lottoGameStartTest(){
        // given
        int inputMoneyAmount = 14000;

        // when
        LottoGame lottoGame = new LottoGame(inputMoneyAmount, new ArrayList<>());
        LottoGameResults lottoGameResults = lottoGame.issueLottoTicket();

        // then
        assertThat(lottoGameResults.getLottoIssueResult().getTicketCount()).isEqualTo(inputMoneyAmount/1000);
    }

}
