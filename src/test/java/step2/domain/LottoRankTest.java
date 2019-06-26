package step2.domain;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRankTest {

    @Test
    @DisplayName("당첨 등수 1등")
    void check_my_rank() {
        LottoStore lottoStore = LottoStore.getInstance();
        Money money = new Money(1_000L);
        Lottos lottos = lottoStore.buyLotto(money, new ChooseLottos(List.of(new Lotto(List.of(LottoNumber.create(1), LottoNumber.create(2), LottoNumber.create(3), LottoNumber.create(4), LottoNumber.create(5), LottoNumber.create(6))))));

        LottoStatistics lottoStatistics = new LottoStatistics(money, lottos);
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(LottoNumber.create(1), LottoNumber.create(2), LottoNumber.create(3), LottoNumber.create(4), LottoNumber.create(5), LottoNumber.create(6))));
        assertThat(lottoStatistics.getMyRanks(winningLotto).get(0)).isEqualTo(LottoRank.FIRST);
    }

}
