package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static lotto.domain.LottoShop.DEFAULT_PRICE_UNIT;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {

    @Test
    @DisplayName("특정 개수 매칭 결과 확인")
    void match_without_bonus() {
        // given
        Lotto winningLotto = Lotto.fromString("16,22,33,41,44,45");
        LottoNumber bonusBall = LottoNumber.of(17);
        Lottos lottos = new Lottos();
        final int money = 10000;
        for (int i = 0; i < 10000 / DEFAULT_PRICE_UNIT - 1; i++) {
            lottos.add(Lotto.fromString("18,23,34,38,42,43"));
        }
        lottos.add(Lotto.fromString("16,22,33,40,42,43"));

        // when
        LottoGame lottoGame = new LottoGame(winningLotto, bonusBall, money);
        LottoResult lottoResult = lottoGame.match(lottos);
        Map<LottoRanking, Integer> rankingMap = lottoResult.getRankingMap();

        // then
        assertThat(lottoResult.getSaveOfReturn()).isEqualTo(0.5);
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
        LottoGame lottoGame = new LottoGame(winningLotto, bonusBall, 0);
        LottoResult lottoResult = lottoGame.match(lottos);

        // then
        assertThat(lottoResult.getTotalPrize()).isEqualTo(LottoRanking.BONUS.prize());
        assertThat(lottoResult.getRankingMap().get(LottoRanking.BONUS)).isEqualTo(1);
    }
}
