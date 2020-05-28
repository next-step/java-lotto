package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoMachineTest {

    @DisplayName("1000원 단위로 로또를 구입할 수 있다.")
    @ParameterizedTest
    @MethodSource("source_buy_validParameters_shouldSucceed")
    public void buy_validParameters_shouldSucceed(String param, int expectedSize) {
        LottoMachine lottoMachine = new LottoMachine();
        Price price = Price.of(param);
        List<Lotto> result = lottoMachine.buy(price);
        assertThat(result.size()).isEqualTo(expectedSize);
    }

    private static Stream<Arguments> source_buy_validParameters_shouldSucceed() {
        return Stream.of(
                Arguments.of("1000", 1),
                Arguments.of("5000", 5));
    }

    @DisplayName("로또 구입 단위가 1000원이 아니면 throw IllegalArgumentException")
    @ParameterizedTest
    @MethodSource("source_buy_invalidParameters_shouldSucceed")
    public void buy_invalidParameters_shouldSucceed(String param) {
        LottoMachine lottoMachine = new LottoMachine();
        Price price = Price.of(param);
        assertThatThrownBy(() -> {
            lottoMachine.buy(price);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> source_buy_invalidParameters_shouldSucceed() {
        return Stream.of(
                Arguments.of("0"),
                Arguments.of("1500"),
                Arguments.of("12345"));
    }
}
