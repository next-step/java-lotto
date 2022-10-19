package lotto.domain;

import lotto.util.LottoExchanger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @Test
    @DisplayName("자동 추첨 수량 확인")
    void pick() {
        // given
        Integer purchasePrice = 14000;

        // when
        Lottos lottos = LottoExchanger.purchaseLottos(purchasePrice);
        Lottos autoPickLottos = lottos.pick();

        // then
        assertThat(autoPickLottos.getLottoList()).hasSize(14);
    }

    @Test
    @DisplayName("랭킹 입력 확인")
    void rank() {
        // given
        Integer purchasePrice = 14000;
        List<Integer> matchNumberList = List.of(1, 2, 3, 4, 5, 6);

        // when
        Lottos lottos = LottoExchanger.purchaseLottos(purchasePrice);
        Lottos pickedLottos = lottos.pick();
        Lottos rankedLottos = pickedLottos.rank(matchNumberList);

        // then
        assertThat(rankedLottos.getLottoList().get(0).getRank()).isNotNull();
    }
}
