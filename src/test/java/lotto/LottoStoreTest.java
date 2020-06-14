package lotto;

import lotto.domain.LottoStore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoStoreTest {

    @ParameterizedTest
    @ValueSource(doubles = {4444, 5555, 500, 777})
    @DisplayName("입력한 돈이 1000원으로 나누어 떨어 지지 않을 경우 Exception")
    void FailToSellLottoIfInputMoneyIsInvalid(double input) {
        assertThatThrownBy(() -> new LottoStore(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("유효한 수치의 돈을 입력했을 경우 입력한 돈과 로또의 장수가 일치 하는 지 테스트")
    @MethodSource("provideValidMoney")
    void LottoCountIsEqualWithMoneyPaid(double input, int expected) {
        LottoStore lottoStore = new LottoStore(input);
        int actual = lottoStore.sellLotto().size();

        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> provideValidMoney() {
        return Stream.of(
                Arguments.of(5000, 5),
                Arguments.of(15000, 15),
                Arguments.of(1000, 1)
        );
    }
}
