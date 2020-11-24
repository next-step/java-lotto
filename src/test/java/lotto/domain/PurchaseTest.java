package lotto.domain;

import lotto.service.NumberSelectionStrategyImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseTest {
    @Test
    @DisplayName("수동 로또 개수가 전체 금액을 넘을 때")
    void createPurchase_manualLottoCountOverMoney() {
        assertThatThrownBy(() ->
                new Purchase(10000, 11))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("money and manual lotto count is wrong");
    }

    @Test
    @DisplayName("구입 금액에 맞는 로또 개수 계산")
    void getLottoNum() {
        int money = 14000;

        int lottoNum = Purchase.getLottoCount(money);

        assertThat(lottoNum).isEqualTo(14);
    }

    @Test
    @DisplayName("수동 자동에 따른 방법으로 로또 뽑았을 때, 총 로또 구매 개수와 같기")
    void drawLottosByMeans() {
        Purchase purchase = new Purchase(10000, 9);
        Function<Integer, Lottos> mean = (count) -> new Lottos(count, new NumberSelectionStrategyImpl());

        Lottos lottos = purchase.drawLottosByMeans(mean, mean);

        assertThat(lottos.checkCount(10)).isTrue();
    }

    @Test
    @DisplayName("자동과 수동으로 로또 뽑은 후 합쳤을 때, 구매한 로또 개수와 다르면 에러")
    void drawLottosByMeans_notSameCount() {
        Purchase purchase = new Purchase(10000, 9);
        Function<Integer, Lottos> integerLottosFunction = (count) -> new Lottos(3, new NumberSelectionStrategyImpl());

        assertThatThrownBy(() ->
                purchase.drawLottosByMeans(integerLottosFunction, integerLottosFunction))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("sum of lotto count are different with total lotto count");

    }
}