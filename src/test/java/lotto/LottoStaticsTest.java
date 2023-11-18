package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottoStaticsTest {

    @Test
    void 당첨_금액을_알려준다() {
        LottoStatics lottoStatics = new LottoStatics();
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))
                , new Lotto(List.of(30, 31, 32, 33, 34, 35, 36)), new Lotto(List.of(30, 31, 32, 33, 34, 35, 37)),
                new Lotto(List.of(18, 22, 43, 33, 23, 13, 3))
        );
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        lottoStatics.classifyRankLotto(lottos, winningLotto);
        assertThat(lottoStatics.rewardWinningLotto(6)).isEqualTo(2000000000);
    }

    @Test
    void 당첨_금액의_총액을_알려준다() {
        LottoStatics lottoStatics = new LottoStatics();
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))
                , new Lotto(List.of(30, 31, 32, 33, 34, 35, 36)), new Lotto(List.of(30, 31, 32, 33, 34, 35, 37)),
                new Lotto(List.of(18, 22, 43, 33, 23, 13, 3))
        );
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        lottoStatics.classifyRankLotto(lottos, winningLotto);
        assertThat(lottoStatics.rewardTotalWinningLottos()).isEqualTo(2000000000);

    }

    @Test
    void 당첨번호와_일치하는_갯수별로_로또갯수를_저장한다() {
        LottoStatics lottoStatics = new LottoStatics();
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))
                , new Lotto(List.of(30, 31, 32, 33, 34, 35, 36)), new Lotto(List.of(30, 31, 32, 33, 34, 35, 37)),
                new Lotto(List.of(18, 22, 43, 33, 23, 13, 3))
        );
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        lottoStatics.classifyRankLotto(lottos, winningLotto);
        assertAll(() -> {
            assertThat(lottoStatics.matchCountRanks(6)).isEqualTo(1);
            assertThat(lottoStatics.matchCountRanks(5)).isEqualTo(0);
        });


    }

}
