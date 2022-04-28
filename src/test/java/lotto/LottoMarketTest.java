package lotto;

import lotto.controller.LottoMarket;
import lotto.model.Lottos;
import lotto.model.RandomLottoGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 상점 판매 테스트")
public class LottoMarketTest {

    @ParameterizedTest
    @CsvSource(value = {"14000:14", "1000:1"}, delimiter = ':')
    @DisplayName("지불한 금액만큼 로또를 구매한다. 1000원당 1개")
    void buyLottoTest(int money, int count) {
        List<Lottos> lottos = LottoMarket.buyLottos(money, new RandomLottoGenerator());

        assertThat(lottos).hasSize(count);
    }

    @Test
    @DisplayName("로또 구입시 지불한 금액이 음수이면 예외가 발생한다.")
    void minusMoneyTest() {
        Assertions.assertThatThrownBy(() -> LottoMarket.buyLottos(-1, new RandomLottoGenerator()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("음수");
    }

    @Test
    @DisplayName("로또 구입시 지불한 금액이 천원 단위가 아니면 예외가 발생한다.")
    void notThousandMoneyTest() {
        Assertions.assertThatThrownBy(() -> LottoMarket.buyLottos(13350, new RandomLottoGenerator()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("천원");
    }
}
