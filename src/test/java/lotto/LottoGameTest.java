package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.Test;


import java.util.List;
import java.util.Map;

import static lotto.LottoTestUtils.createLottoTicket;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoGameTest {

    @Test
    void gameStart() {
        // 당첨 티켓 생성
        LottoTicket winningTicket = createLottoTicket(List.of(1, 2, 3, 4, 5, 6));

        // 구매한 티켓 리스트 생성
        List<LottoTicket> tickets = List.of(
                createLottoTicket(List.of(1, 2, 3, 7, 8, 9)),
                createLottoTicket(List.of(11, 12, 13, 14, 15, 16))
        );

        // 실제 게임 실행
        LottoGame lottoGame = new LottoGame(new LottoTickets(tickets));
        GameResult gameResult = lottoGame.gameStart(winningTicket);

        // 기대하는 결과 생성
        Map<Rank, Integer> expectedStats = Map.of(
                Rank.FIRST, 0,
                Rank.SECOND, 0,
                Rank.THIRD, 0,
                Rank.FOURTH, 1,
                Rank.MISS, 1
        );
        GameResult expectedGameResult = new GameResult(expectedStats, 2.5);

        assertThat(gameResult).isEqualTo(expectedGameResult);
    }


}
