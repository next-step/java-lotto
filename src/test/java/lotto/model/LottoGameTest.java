package lotto.model;

import lotto.model.lotto.LottoGame;
import lotto.model.lotto.LottoNumber;
import lotto.model.lotto.LottoTicket;
import lotto.model.lotto.WinningTicket;
import lotto.model.rank.Rank;
import lotto.model.rank.RankResult;
import lotto.model.rank.RankResults;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoGameTest {

    private LottoGame lottoGame;

    @BeforeEach
    void setUp() {
        List<LottoTicket> lottoTickets = initLottoTickets();
        WinningTicket winningTicket = initWinningTicket(List.of(1, 2, 3, 4, 5, 6), 7);
        lottoGame = new LottoGame(lottoTickets, winningTicket);
    }

    @Test
    @DisplayName("로또 결과를 확인하다")
    void produceResultStrategy() {

        RankResults rankResults = lottoGame.start();
        List<RankResult> rankResultList = rankResults.getRankResults();
        assertAll(
                () -> assertThat(rankResultList).contains(new RankResult(Rank.FIRST, 1)),
                () -> assertThat(rankResultList).contains(new RankResult(Rank.SECOND, 2)),
                () -> assertThat(rankResultList).contains(new RankResult(Rank.THIRD, 0)),
                () -> assertThat(rankResultList).contains(new RankResult(Rank.FIFTH, 1))
        );
    }

    private WinningTicket initWinningTicket(List<Integer> numbers, int bonusNumber) {
        List<LottoNumber> lottoNumbers = numbers.stream()
                .map(LottoNumber::create)
                .collect(Collectors.toList());

        LottoTicket lottoTicket = new LottoTicket(new HashSet<>(lottoNumbers));
        LottoNumber bonusLottoNumber = LottoNumber.create(bonusNumber);

        return new WinningTicket(lottoTicket, bonusLottoNumber);
    }

    private List<LottoTicket> initLottoTickets() {
        return List.of(
                new LottoTicket(Set.of(
                        LottoNumber.create(1),
                        LottoNumber.create(2),
                        LottoNumber.create(3),
                        LottoNumber.create(4),
                        LottoNumber.create(5),
                        LottoNumber.create(6)
                )
                ), new LottoTicket(Set.of(
                        LottoNumber.create(1),
                        LottoNumber.create(2),
                        LottoNumber.create(3),
                        LottoNumber.create(4),
                        LottoNumber.create(7),
                        LottoNumber.create(8)
                )
                ),
                new LottoTicket(Set.of(
                        LottoNumber.create(1),
                        LottoNumber.create(2),
                        LottoNumber.create(3),
                        LottoNumber.create(4),
                        LottoNumber.create(5),
                        LottoNumber.create(7)
                )),
                new LottoTicket(Set.of(
                        LottoNumber.create(1),
                        LottoNumber.create(2),
                        LottoNumber.create(3),
                        LottoNumber.create(12),
                        LottoNumber.create(15),
                        LottoNumber.create(20)
                ))
        );
    }

}