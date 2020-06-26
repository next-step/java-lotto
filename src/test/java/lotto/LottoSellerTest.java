package lotto;

import lotto.domain.LottoSeller;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoSellerTest {

    @ParameterizedTest
    @DisplayName("수동 입력 번호의 갯수가 전체 구매 로또 갯수 보다 많을 경우 fail")
    @MethodSource("provideNumberOfLotto")
    void FailIfNumberOfManualBiggerThanTotalBuyingTicket(int numberOfLottoByMoneyPaid, int numberOfManual) {

        assertThatThrownBy(() -> LottoSeller.getNumberOfAutoLottoTicket(numberOfLottoByMoneyPaid, numberOfManual))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideNumberOfLotto() {
        return Stream.of(
                Arguments.of(5, 10),
                Arguments.of(6, 7)
        );
    }

}
