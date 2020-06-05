package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoFactoryTest {

    @DisplayName("구입 금액이 1000원 미만인 경우 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -4, 999})
    public void whenInputNegativeThenExceptionTest(int price){
        // then
        assertThatIllegalArgumentException().isThrownBy(
                () -> LottoFactory.createLottos(price)
        );
    }

    @DisplayName("구입 금액을 입력하면 로또 가격으로 나눈 수 만큼의 로또를 발급한다.")
    @ParameterizedTest
    @CsvSource(value = {"1000, 1", "3000, 3", "10000, 10"})
    public void whenInputPriceThenGenerateLottoTest(int price, int expected){
        // when
        List<Lotto> lottos = LottoFactory.createLottos(price);

        System.out.println(lottos.get(0).getNumbers());

        // then
        assertThat(lottos).hasSize(expected);
    }
}
