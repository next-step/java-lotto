package lotto.domain;

import lotto.domain.dto.ManualNumberDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    private static Stream<Arguments> provideManualLottoNumbersAndNumberOfAutoTicket() {
        return Stream.of(
                Arguments.of(new ArrayList<ManualNumberDto>(), 2, 2),
                Arguments.of(Arrays.asList(new ManualNumberDto("1, 2, 3, 4, 5, 6")), 1, 2)
        );
    }

    @DisplayName("수동 로또 개수와 자동 로또 개수에 맞는 로또 티켓을 생성한다.")
    @ParameterizedTest
    @MethodSource("provideManualLottoNumbersAndNumberOfAutoTicket")
    void purchaseLottoTicket(List<ManualNumberDto> manualNumberDtos, int numberOfAutoTicket, int expectedResult) {
        LottoBill lottoBill = LottoMachine.purchaseLottoTicket(manualNumberDtos, numberOfAutoTicket);

        assertThat(lottoBill.getAllTickets().size()).isEqualTo(expectedResult);
    }
}
