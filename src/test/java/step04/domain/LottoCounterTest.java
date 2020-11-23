package step04.domain;

import exception.LackOfMoneyException;
import exception.OutOfLottoManualCountException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoCounterTest {



    @DisplayName("생성자")
    @Test
    void test_constructor() {
        int payment = 2000;
        int countOfManualLotto = 1;

        assertThat(LottoCounter.of(payment, countOfManualLotto))
                .isEqualTo(LottoCounter.of(payment, countOfManualLotto));
    }

    private static Stream<Integer> provideLackOfMoneyResult() {
        return Stream.of(
                -1, 0, 999
        );
    }

    @DisplayName("지불금액이 1000원 이하이면 에러 던짐")
    @ParameterizedTest
    @MethodSource("provideLackOfMoneyResult")
    void test_validatePayment(Integer payment) {
        Integer COUNT_OF_MANUAL_LOTTO = 0;

        assertThatExceptionOfType(LackOfMoneyException.class)
                .isThrownBy(() -> {
                    LottoCounter.of(payment, COUNT_OF_MANUAL_LOTTO);
                });
    }

    private static Stream<Integer> provideOutOfManualCountResult() {
        return Stream.of(
                -1, 4
        );
    }

    @DisplayName("수동 로또 수가 0보다 작거나 구매한 로또 수보다 클 경우 에러 던짐")
    @ParameterizedTest
    @MethodSource("provideOutOfManualCountResult")
    void test_validateCountOfManualLotto(Integer countOfManualLotto) {
        Integer PAYMENT = 3000;

        assertThatExceptionOfType(OutOfLottoManualCountException.class)
                .isThrownBy(() -> LottoCounter.of(PAYMENT, countOfManualLotto));
    }

}
