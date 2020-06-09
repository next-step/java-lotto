package dev.dahye.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("로또 주문 객체")
class LottoOrderTest {
    @ParameterizedTest(name = "로또의 전체 갯수는 {0}개, 수동 로또 갯수는 {1}인 경우")
    @MethodSource("lottoOrders_fail")
    @DisplayName("수동 로또 갯수가 전체 로또 갯수를 초과한 경우 IllegalArgument Exception throw")
    void validate_count_of_manual_lotto(int totalCountOfLotto, int countOfManualLotto) {
        LottoMoney lottoMoney = new LottoMoney(totalCountOfLotto * LottoMoney.PRICE_PER_LOTTO);
        assertThatThrownBy(() -> LottoOrder.of(lottoMoney, countOfManualLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("수동 로또 갯수는 전체 갯수를 초과할 수 없습니다.");
    }

    private static Stream<Arguments> lottoOrders_fail() {
        return Stream.of(
                arguments(1, 2),
                arguments(2, 3)
        );
    }

    @ParameterizedTest(name = "수동 로또 갯수가 {0}인 경우")
    @ValueSource(ints = {-1, -2, -3})
    @DisplayName("수동 로또 갯수가 음수인 경우 IllegalArgument Exception throw")
    void validate_count_of_manual_lotto_is_minus(int countOfManualLotto) {
        LottoMoney lottoMoney = new LottoMoney(LottoMoney.PRICE_PER_LOTTO);
        assertThatThrownBy(() -> LottoOrder.of(lottoMoney, countOfManualLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("수동 로또 갯수는 음수일 수 없습니다.");
    }

    @ParameterizedTest(name = "수동 로또 갯수가 {1}인 경우")
    @MethodSource("lottoOrders_success")
    @DisplayName("수동 로또 갯수가 유효한 경우")
    void lotto_order_Success(int totalCountOfLotto, int countOfManualLotto) {
        LottoMoney lottoMoney = new LottoMoney(totalCountOfLotto * LottoMoney.PRICE_PER_LOTTO);
        assertThat(LottoOrder.of(lottoMoney, countOfManualLotto)).isNotNull();
    }

    private static Stream<Arguments> lottoOrders_success() {
        return Stream.of(
                arguments(1, 0),
                arguments(1, 1),
                arguments(2, 1)
        );
    }
}