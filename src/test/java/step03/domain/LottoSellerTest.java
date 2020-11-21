package step03.domain;

import exception.LackOfMoneyException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoSellerTest {

    private static Stream<Arguments> providePaymentResult() {
        return Stream.of(
                Arguments.of(1000, 1),
                Arguments.of(10000, 10),
                Arguments.of(100000, 100),
                Arguments.of(100001, 100)
        );
    }

    private static Stream<Integer> provideLackOfMoneyResult() {
        return Stream.of(
                -1, 0, 999
        );
    }

    @DisplayName("금액을 지불받은 만큼 로또를 생성하여주는지 검사")
    @ParameterizedTest
    @MethodSource("providePaymentResult")
    void test_generateLottos(Integer payment, Integer countOfLottos) {
        assertThat(LottoSeller.generateLottos(payment).size())
                .isEqualTo(countOfLottos);
    }

    @DisplayName("지불금액이 1000원 이하이면 에러 던짐")
    @ParameterizedTest
    @MethodSource("provideLackOfMoneyResult")
    void test_validatePayment(Integer payment) {
        assertThatExceptionOfType(LackOfMoneyException.class)
                .isThrownBy(() -> {
                    LottoSeller.generateLottos(payment);
                });
    }

}
