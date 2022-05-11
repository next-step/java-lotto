package lotto;

import lotto.model.LottoMarket;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.RandomLottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("구매 금액에 맞는 로또를 판매하는 로또 상점 테스트")
public class LottoMarketTest {

    @ParameterizedTest
    @CsvSource(value = {"14000:14", "1000:1"}, delimiter = ':')
    @DisplayName("지불한 금액만큼 로또를 구매한다. 1000원당 1개")
    void buyLottoTest(int money, int count) {
        Lottos lottos = LottoMarket.buyLottos(new Money(money), new RandomLottoGenerator());

        assertThat(lottos.size()).isEqualTo(count);
    }

    @Test
    @DisplayName("로또 구입시 지불한 금액이 null이면 예외가 발생한다.")
    void buyingMoneyNullTest() {
        assertThatThrownBy(() -> LottoMarket.buyLottos(null, new RandomLottoGenerator()))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("로또 구입시 생성 전략이 null이면 예외가 발생한다.")
    void lottoGeneratorNullTest() {
        assertThatThrownBy(() -> LottoMarket.buyLottos(new Money(1234), null))
                .isInstanceOf(NullPointerException.class);
    }
}
