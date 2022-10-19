package lotto.util;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @Test
    @DisplayName("결과 배열 확인")
    void rankResult() {
        // given
        Integer purchasePrice = 14000;
        Lottos lottos = LottoExchanger.purchaseLottos(purchasePrice);
        Lottos pickedLottos = lottos.pick();
        Lottos rankedLottos = pickedLottos.rank(List.of(1, 2, 3, 4, 5, 6));

        // when
        List<Rank> rankList = LottoResult.rankResult(rankedLottos);

        // then
        assertThat(rankList).hasSize(14);
    }

    @Test
    @DisplayName("수익률 확인")
    void yieldResult() {
        // given
        Lotto lotto = new Lotto().auto(List.of(1, 2, 3, 4, 5, 6));
        Lottos pickedLottos = new Lottos(1, 1000, List.of(lotto));
        Lottos rankedLottos = pickedLottos.rank(List.of(1, 2, 3, 4, 5, 6));

        // when
        Integer integer = LottoResult.yieldResult(rankedLottos);

        // then
        assertThat(integer).isEqualTo(2000000);
    }
}
