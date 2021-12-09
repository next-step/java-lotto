package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Money;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoControllerTest {

    @ParameterizedTest(name = "로또를 한 장에 1000원에 구매할 수 있다")
    @ValueSource(ints = {13000, 13001, 13999})
    void testBuyLotto(int moneyValue) {
        // Given
        Money money = new Money(moneyValue);

        // When
        List<Lotto> lottos = LottoController.buyLotto(money);

        // Then
        assertThat(lottos).isNotNull();
        assertThat(lottos.size()).isEqualTo(13);
    }
}
