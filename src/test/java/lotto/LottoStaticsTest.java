package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoStaticsTest {


    @Test
    void 당첨된_갯수를_알려준다() {
        LottoStatics lottoStatics = new LottoStatics();
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 9))
        );
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonusBall = new LottoNumber(9);
        Map<Rank, Integer> rankMap = Map.of(Rank.FIRST, 1, Rank.SECOND, 1);
        WinningLottos result = new WinningLottos(rankMap);
        assertThat(lottoStatics.classifyRankLotto(lottos, winningLotto, bonusBall)).isEqualTo(result);
    }

}
