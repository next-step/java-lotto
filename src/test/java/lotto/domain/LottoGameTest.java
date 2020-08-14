package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {

    @Test
    @DisplayName("특정 개수 매칭 결과 확인")
    void match_without_bonus() {
        // given
        Lotto winningLotto = Lotto.fromString("16,22,33,41,44,45");
        LottoNumber bonusBall = LottoNumber.of(17);
        Lottos lottos = new Lottos();
        final int buyCount = 10;
        for (int i = 0; i < 9; i++) {
            lottos.add(Lotto.fromString("18,23,34,38,42,43"));
        }
        lottos.add(Lotto.fromString("16,22,33,40,42,43"));

        // when
        LottoGame lottoGame = new LottoGame(winningLotto, bonusBall);
        LottoResult lottoResult = lottoGame.match(lottos);
        Map<LottoRanking, Integer> rankingMap = lottoResult.getRankingMap();

        // then
        assertThat(lottoResult.getSaveOfReturn()).isEqualTo(lottoResult.getTotalPrize() * 1.0 / (buyCount * LottoShop.DEFAULT_PRICE_UNIT));
        assertThat(lottoResult.getTotalPrize()).isEqualTo(LottoRanking.FOURTH.prize());
        assertThat(rankingMap).containsKey(LottoRanking.FOURTH);
    }

    @Test
    @DisplayName("특정 개수 매칭 결과 확인 (보너스볼)")
    void match_with_bonus() {
        // given
        Lotto winningLotto = Lotto.fromString("16,22,33,41,44,45");
        LottoNumber bonusBall = LottoNumber.of(43);
        Lottos lottos = new Lottos();
        lottos.add(Lotto.fromString("16,22,33,41,43,45"));
        lottos.add(Lotto.fromString("6,7,12,13,14,25"));

        // when
        LottoGame lottoGame = new LottoGame(winningLotto, bonusBall);
        LottoResult lottoResult = lottoGame.match(lottos);

        // then
        assertThat(lottoResult.getTotalPrize()).isEqualTo(LottoRanking.BONUS.prize());
        assertThat(lottoResult.getRankingMap().get(LottoRanking.BONUS)).isEqualTo(1);
    }
}
