package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoFactoryTest {

    @DisplayName("구입 금액이 음수인 경우 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -4})
    public void whenInputNegativeThenExceptionTest(int price){
        // then
        assertThatIllegalArgumentException().isThrownBy(
                () -> LottoFactory.generateLottos(price)
        );
    }

    @DisplayName("구입 금액을 입력하면 로또 가격으로 나눈 수 만큼의 로또를 발급한다.")
    @ParameterizedTest
    @CsvSource(value = {"1000, 1", "3000, 3", "10000, 10"})
    public void whenInputPriceThenGenerateLottoTest(int price, int expected){
        // when
        List<Lotto> lottos = LottoFactory.generateLottos(price);

        // then
        assertThat(lottos).hasSize(expected);
    }
}
