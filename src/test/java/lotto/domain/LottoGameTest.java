package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {

    @Test
    @DisplayName("특정 개수 매칭 결과 확인")
    void match() {
        // given
        Lotto winningLotto = Lotto.fromString("16,22,33,41,45,46");
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(Lotto.fromString("16,22,33,40,44,47"));
        lottos.add(Lotto.fromString("16,22,33,39,44,47"));

        // when
        LottoResult lottoResult = LottoGame.match(winningLotto, lottos);

        // then
        assertThat(lottoResult.getTotalPrize()).isEqualTo(10000);
        assertThat(lottoResult.getRankingMap().get(LottoRanking.FOURTH)).isEqualTo(2);
    }
}
