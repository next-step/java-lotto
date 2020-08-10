package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {

    @Test
    @DisplayName("특정 개수 매칭 결과 확인")
    void match_without_bonus() {
        // given
        Lotto winningLotto = Lotto.fromString("16,22,33,41,44,45");
        LottoNumber bonusBall = LottoNumber.of(17);
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(Lotto.fromString("16,22,33,38,42,45"));
        lottos.add(Lotto.fromString("16,22,33,39,43,45"));

        // when
        LottoResult lottoResult = LottoGame.match(winningLotto, bonusBall, lottos);
        Map<LottoRanking, Integer> rankingMap = lottoResult.getRankingMap();

        // then
        assertThat(lottoResult.getTotalPrize()).isEqualTo(100_000);
        assertThat(rankingMap).containsKey(LottoRanking.THIRD);
    }

    @Test
    @DisplayName("특정 개수 매칭 결과 확인 (보너스볼)")
    void match_with_bonus() {
        // given
        Lotto winningLotto = Lotto.fromString("16,22,33,41,44,45");
        LottoNumber bonusBall = LottoNumber.of(45);
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(Lotto.fromString("16,22,30,41,44,45"));
        lottos.add(Lotto.fromString("6,7,12,13,14,25"));

        // when
        LottoResult lottoResult = LottoGame.match(winningLotto, bonusBall, lottos);

        // then
        assertThat(lottoResult.getTotalPrize()).isEqualTo(LottoRanking.BONUS.prize());
        assertThat(lottoResult.getRankingMap().get(LottoRanking.BONUS)).isEqualTo(1);
    }
}
