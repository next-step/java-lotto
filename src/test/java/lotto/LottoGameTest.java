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

        // 구매한 티켓 리스트 생성
        List<LottoTicket> tickets = List.of(
                createLottoTicket(List.of(1, 2, 3, 4, 5, 7)),
                createLottoTicket(List.of(11, 12, 13, 14, 15, 16))
        );

        // 실제 게임 실행
        LottoGame lottoGame = new LottoGame(new LottoTickets(tickets));
        GameResult gameResult = lottoGame.gameStart(new WinningLottoTicket("1, 2, 3, 4, 5, 6", 7));

        // 기대하는 결과 생성 (2등, 꼴등)
        Map<Rank, Integer> expectedStats = Map.of(
                Rank.FIRST, 0,
                Rank.SECOND, 1,
                Rank.THIRD, 0,
                Rank.FOURTH, 0,
                Rank.FIFTH, 0,
                Rank.MISS, 1
        );
        GameResult expectedGameResult = new GameResult(expectedStats, 1500.0);

        assertThat(gameResult).isEqualTo(expectedGameResult);
    }


}
