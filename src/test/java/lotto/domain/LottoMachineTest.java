package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoMachineTest {

    @DisplayName("1000원 단위로 자동 로또를 구입할 수 있다")
    @ParameterizedTest
    @MethodSource("source_buy_validPrice_shouldSucceed")
    public void buy_validPrice_shouldSucceed(String param, int expectedSize) {
        LottoMachine lottoMachine = new LottoMachine(new AutoLottoGenerator());
        Price price = Price.of(param);
        List<Lotto> result = lottoMachine.buy(price, Collections.emptyList());
        assertThat(result.size()).isEqualTo(expectedSize);
    }

    private static Stream<Arguments> source_buy_validPrice_shouldSucceed() {
        return Stream.of(
                Arguments.of("1000", 1),
                Arguments.of("5000", 5));
    }

    @DisplayName("로또 구입 단위가 1000원이 아니면 throw IllegalArgumentException")
    @ParameterizedTest
    @MethodSource("source_buy_invalidPrice_shouldSucceed")
    public void buy_invalidPrice_shouldSucceed(String param) {
        LottoMachine lottoMachine = new LottoMachine(new AutoLottoGenerator());
        Price price = Price.of(param);
        assertThatThrownBy(() -> {
            lottoMachine.buy(price, Collections.emptyList());
        }).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> source_buy_invalidPrice_shouldSucceed() {
        return Stream.of(
                Arguments.of("0"),
                Arguments.of("1500"),
                Arguments.of("12345"));
    }

    @DisplayName("로또 생성시에 수동으로 입력받은 로또가 포함되어야 한다")
    @ParameterizedTest
    @MethodSource("source_buy_manualLotto_shouldSucceed")
    public void buy_manualLotto_shouldSucceed(String param, List<Integer> manualLottoNumbersList) {
        LottoMachine lottoMachine = new LottoMachine(new AutoLottoGenerator());
        Price price = Price.of(param);
        List<Lotto> result = lottoMachine.buy(price, Arrays.asList(manualLottoNumbersList));

        Lotto manualLotto = new Lotto(manualLottoNumbersList);
        assertThat(result.contains(manualLotto)).isTrue();
    }

    private static Stream<Arguments> source_buy_manualLotto_shouldSucceed() {
        return Stream.of(
                Arguments.of("3000", Arrays.asList(1, 2, 3, 4, 5, 6)),
                Arguments.of("3000", Arrays.asList(3, 23, 34, 19, 43, 6)));
    }

    @DisplayName("수동으로 구매하고자 하는 로또 금액이 구입금액보다 비싸면 IllegalArgumentException")
    @ParameterizedTest
    @MethodSource("source_buy_manualLottoOverPrice_shouldFail")
    public void buy_manualLottoOverPrice_shouldFail(String param, List<List<Integer>> manualLottoNumbersList) {
        LottoMachine lottoMachine = new LottoMachine(new AutoLottoGenerator());
        Price price = Price.of(param);
        assertThatThrownBy(() -> {
            lottoMachine.buy(price, manualLottoNumbersList);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> source_buy_manualLottoOverPrice_shouldFail() {
        return Stream.of(
                Arguments.of("1000", Arrays.asList(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 4, 5, 6))),
                Arguments.of("2000", Arrays.asList(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 4, 5, 6))));
    }
}
