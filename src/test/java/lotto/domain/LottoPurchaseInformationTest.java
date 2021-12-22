package lotto.domain;

import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoPurchaseInformationTest {


    @DisplayName("수동 로또 개수가 구입 금액을 초과하면 에러가 발생한다.")
    @ParameterizedTest
    @MethodSource("provideValuesOfValidateLottoTicket")
    void validateNumberOfLottoTicket(List<String> manuallyPickedLottoTickets, int purchaseAmount) {
        assertThatThrownBy(() -> LottoPurchaseInformation.of(purchaseAmount, manuallyPickedLottoTickets)).isInstanceOf(LottoException.class);
    }

    private static Stream<Arguments> provideValuesOfValidateLottoTicket() {
        return Stream.of(
                Arguments.of(
                        Arrays.asList(
                                "1, 2, 3, 4, 5, 6",
                                "1, 2, 3, 4, 5, 7",
                                "1, 2, 3, 4, 5, 8"
                        )
                        , 2500
                ),
                Arguments.of(
                        Arrays.asList(
                                "1, 2, 3, 4, 5, 6",
                                "1, 2, 3, 4, 5, 7",
                                "1, 2, 3, 4, 5, 8",
                                "1, 2, 3, 4, 5, 8"
                        )
                        , 3800
                )
        );
    }

    @DisplayName("수동 로또와 구입 금액을 입력하면 자동 로또 개수를 알 수 있다.")
    @ParameterizedTest
    @MethodSource("provideValuesOfAutomaticTicket")
    void numberOfAutomaticTicket(List<String> manuallyPickedLottoTickets, int purchaseAmount, int numberOfAutomaticTicket) {
        LottoPurchaseInformation info = LottoPurchaseInformation.of(purchaseAmount, manuallyPickedLottoTickets);
        assertThat(info.numberOfAutomaticTicket()).isEqualTo(numberOfAutomaticTicket);
    }

    private static Stream<Arguments> provideValuesOfAutomaticTicket() {
        return Stream.of(
                Arguments.of(
                        Arrays.asList(
                                "1, 2, 3, 4, 5, 6",
                                "1, 2, 3, 4, 5, 7",
                                "1, 2, 3, 4, 5, 8"
                        )
                        , 3000, 0
                ),
                Arguments.of(
                        Arrays.asList(
                                "1, 2, 3, 4, 5, 6",
                                "1, 2, 3, 4, 5, 7",
                                "1, 2, 3, 4, 5, 8",
                                "1, 2, 3, 4, 5, 8"
                        )
                        , 6700, 2
                )
        );
    }


}