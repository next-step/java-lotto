package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoGameTest {

    private LottoGame lottoGame;

    @BeforeEach
    void setUp() {
        List<LottoTicket> lottoTickets = initLottoTickets();
        WinningTicket winningTicket = initWinningTicket();
        lottoGame = new LottoGame(lottoTickets, winningTicket);
    }

    @Test
    @DisplayName("로또 결과를 확인하다")
    void produceResultStrategy() {

        RankResults rankResults = lottoGame.start();
        List<RankResult> rankResultList = rankResults.getRankResults();
        assertAll(
                () -> assertThat(rankResultList).contains(new RankResult(Rank.FIRST, 1)),
                () -> assertThat(rankResultList).contains(new RankResult(Rank.SECOND, 0)),
                () -> assertThat(rankResultList).contains(new RankResult(Rank.THIRD, 0)),
                () -> assertThat(rankResultList).contains(new RankResult(Rank.FOURTH, 1))
        );
    }

    private WinningTicket initWinningTicket() {
        return new WinningTicket(Set.of(
                new LottoNumber(3),
                new LottoNumber(6),
                new LottoNumber(9),
                new LottoNumber(12),
                new LottoNumber(15),
                new LottoNumber(18)
        ));
    }

    private List<LottoTicket> initLottoTickets() {
        return List.of(
                new LottoTicket(Set.of(
                        new LottoNumber(1),
                        new LottoNumber(5),
                        new LottoNumber(10),
                        new LottoNumber(20),
                        new LottoNumber(30),
                        new LottoNumber(45)
                )
                ), new LottoTicket(Set.of(
                        new LottoNumber(2),
                        new LottoNumber(4),
                        new LottoNumber(6),
                        new LottoNumber(8),
                        new LottoNumber(12),
                        new LottoNumber(15)
                )
                ),
                new LottoTicket(Set.of(
                        new LottoNumber(3),
                        new LottoNumber(6),
                        new LottoNumber(9),
                        new LottoNumber(12),
                        new LottoNumber(15),
                        new LottoNumber(18)
                ))
        );
    }

}