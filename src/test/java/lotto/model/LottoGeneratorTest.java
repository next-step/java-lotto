package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoGeneratorTest {

    private final LottoGenerator generator = new LottoGenerator();

    @ParameterizedTest
    @DisplayName("금액에 따라 적절한 로또 개수를 발급한다")
    @CsvSource(value = {"1000=1", "10000=10"}, delimiter = '=')
    public void count(int price, int expected) {
        List<Lotto> lottos = generator.generate(price);
        assertThat(lottos).hasSize(expected);
    }

    @ParameterizedTest
    @DisplayName("로또를 하나도 살 수 없다면 예외가 난다.")
    @ValueSource(ints = {Lotto.PRICE - 1, 0, -1000})
    public void cannotBuy(int price) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> generator.generate(price));
    }
}