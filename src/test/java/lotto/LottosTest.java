package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottosTest {

    @Test
    void 최소구입금액_1000원_검증() {
        assertThatThrownBy(() -> {
            new Lottos(500);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 금액만큼_로또_생성() {
        Lottos lottos = new Lottos(14000);
        assertThat(lottos.returnPurchaseQuantity()).isEqualTo(14);
    }

    @Test
    void 로또_결과() {
        Lottos lottos = new Lottos(Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9)),
                new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12))));

        Lotto lastWinningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        Map<LottoRank, Integer> results = new HashMap<>();
        results.put(LottoRank.FIFTH, 1);
        results.put(LottoRank.FOURTH, 0);
        results.put(LottoRank.THIRD, 0);
        results.put(LottoRank.FIRST, 1);
        LottoResults lottoResults = new LottoResults(results);

        assertThat(lottos.createLottoResults(lastWinningLotto)).isEqualTo(lottoResults);
    }
}