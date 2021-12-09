package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    @Test
    @DisplayName("주어진 6개의 숫자로 로또를 만들 수 있다")
    void testLottoGivenNumbers() {
        // Given
        LottoNumbers expected = new LottoNumbers(
                Arrays.asList(
                        new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(5),
                        new LottoNumber(6)
                ));
        Lotto lotto = new Lotto(expected);

        // When
        LottoNumbers actual = lotto.getLottoNumbers();

        // Then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest(name = "로또를 한 장에 1000원에 구매할 수 있다")
    @ValueSource(ints = {13000, 13001, 13999})
    void testBuyLotto(int moneyValue) {
        // Given
        Money money = new Money(moneyValue);

        // When
        List<Lotto> lottos = Lotto.buyLotto(money);

        // Then
        assertThat(lottos).isNotNull();
        assertThat(lottos.size()).isEqualTo(13);
    }
}