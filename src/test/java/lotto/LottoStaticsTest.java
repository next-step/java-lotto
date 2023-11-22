package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottoStaticsTest {


    @Test
    void 당첨된_갯수를_알려준다() {
        LottoStatics lottoStatics = new LottoStatics();
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 9))
        );
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonusBall = new LottoNumber(9);
        lottoStatics.classifyRankLotto(lottos, winningLotto, bonusBall);
        Map<Rank, Integer> rankMap = Map.of(Rank.FIRST, 1, Rank.SECOND, 1);
        WinningLottos result = new WinningLottos(rankMap);
        assertThat(lottoStatics.winningLottos()).isEqualTo(result);
    }

    @Test
    void 당첨_금액을_알려준다() {
        Map<Rank, Integer> rankMap = Map.of(Rank.FIRST, 1);
        LottoStatics lottoStatics = new LottoStatics(new WinningLottos(rankMap));
        assertThat(lottoStatics.rewardWinningLotto(6, false)).isEqualTo(2000000000);
    }

    @Test
    void 당첨_금액의_총액을_알려준다() {
        Map<Rank, Integer> rankMap = Map.of(Rank.FIRST, 1, Rank.FOURTH, 1);
        LottoStatics lottoStatics = new LottoStatics(new WinningLottos(rankMap));
        assertThat(lottoStatics.rewardTotalWinningLottos()).isEqualTo(2000050000);

    }

    @Test
    void 당첨번호와_일치하는_갯수별로_로또갯수를_저장한다() {
        LottoStatics lottoStatics = new LottoStatics();
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))
                , new Lotto(List.of(1, 2, 3, 4, 5, 9)), new Lotto(List.of(30, 31, 32, 33, 34, 35, 37)),
                new Lotto(List.of(18, 22, 43, 33, 23, 13, 3))
        );
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonusBall = new LottoNumber(9);
        lottoStatics.classifyRankLotto(lottos, winningLotto, bonusBall);
        assertAll(() -> {
            assertThat(lottoStatics.matchCountRanks(6, false)).isEqualTo(1);
            assertThat(lottoStatics.matchCountRanks(5, true)).isEqualTo(1);
        });


    }

}
