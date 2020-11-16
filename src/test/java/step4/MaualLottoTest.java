package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import step4.lotto.LottoTicketMachine;
import step4.lotto.firstcollection.MarkingNumbers;
import step4.strategy.LottoNumberMakeStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static step4.Constant.ERROR_INVALID_PARAMETER;
import static step4.Constant.ERROR_NOT_ENOUGH_MONEY;

public class MaualLottoTest {


    @DisplayName("수동 로또 구매 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1000:1", "1000:0", "2000:2"}, delimiter = ':')
    void purchaseManualLotto(int money, int wantedTicketCount) {
        int result = LottoTicketMachine.countAllowManualTicket(money, wantedTicketCount);
        assertThat(result).isEqualTo(wantedTicketCount);
    }

    @DisplayName("수동 로또 구매 예외 테스트")
    @ParameterizedTest
    @MethodSource("provideManualLottoCountAndResultForException")
    void purchaseManualLottoForException(int money, int wantedTicketCount, String errorMessage) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    int manualTicketCount = LottoTicketMachine.countAllowManualTicket(money, wantedTicketCount);
                }).withMessage(errorMessage);
    }

    private static Stream<Arguments> provideManualLottoCountAndResultForException() {
        return Stream.of(
                Arguments.of(2000, -1, ERROR_INVALID_PARAMETER),
                Arguments.of(2000, 3, ERROR_NOT_ENOUGH_MONEY)
        );
    }


}
