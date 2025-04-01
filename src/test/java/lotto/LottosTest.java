package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static lotto.util.LottoNumberConverter.toLottoNumbers;
import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @Test
    public void 수동로또_자동로또_개수를_반환한다() {
        Lotto lotto1 = Lotto.generateManualLotto(LottoNumber.from(List.of(1, 2, 3, 4, 5, 6)));
        Lotto lotto2 = Lotto.generateManualLotto(LottoNumber.from(List.of(4, 5, 6, 7, 8, 9)));
        Lotto lotto3 = Lotto.generateAutoLotto();
        List<Lotto> lottoList = List.of(lotto1, lotto2, lotto3);

        Lottos lottos = new Lottos(lottoList);

        int manualLottoCount = lottos.countManualLotto();
        int autoLottoCount = lottos.countAutoLotto();

        assertThat(manualLottoCount).isEqualTo(2);
        assertThat(autoLottoCount).isEqualTo(1);
    }

    @Test
    public void 구매한_전체_로또의_당첨_결과를_반환한다_보너스볼판단포함() {
        WinningLotto winningLotto = new WinningLotto(toLottoNumbers(List.of(1, 2, 3, 4, 5, 6)), 7);

        Lotto firstRankLotto = Lotto.generateManualLotto(LottoNumber.from(List.of(1, 2, 3, 4, 5, 6)));
        Lotto secondRankLotto = Lotto.generateManualLotto(LottoNumber.from(List.of(1, 2, 3, 4, 5, 7)));
        Lotto thirdRankLotto = Lotto.generateManualLotto(LottoNumber.from(List.of(1, 2, 3, 4, 5, 38)));
        Lottos lottos = new Lottos(List.of(firstRankLotto, secondRankLotto, thirdRankLotto));

        Map<Rank, Integer> lottoStatistics = lottos.analyzeLottoStatistics(winningLotto);

        assertThat(lottoStatistics.get(Rank.FIRST)).isEqualTo(1);
        assertThat(lottoStatistics.get(Rank.SECOND)).isEqualTo(1);
        assertThat(lottoStatistics.get(Rank.THIRD)).isEqualTo(1);
        assertThat(lottoStatistics.get(Rank.FOURTH)).isEqualTo(0);
        assertThat(lottoStatistics.get(Rank.NO_PRIZE)).isEqualTo(0);
    }

}
