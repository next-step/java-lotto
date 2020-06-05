package lotto.domain;

import lotto.domain.dto.ManualNumberDto;
import lotto.domain.vo.LottoMoney;
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
                Arguments.of(new ArrayList<ManualNumberDto>(),
                        new LottoMoney(2000, 0), 2),
                Arguments.of(Arrays.asList(new ManualNumberDto("1, 2, 3, 4, 5, 6")),
                        new LottoMoney(2000, 1), 2)
        );
    }

    @DisplayName("수동 로또 개수와 자동 로또 개수에 맞는 로또 티켓을 생성한다.")
    @ParameterizedTest
    @MethodSource("provideManualLottoNumbersAndNumberOfAutoTicket")
    void purchaseLottoTicket(List<ManualNumberDto> manualNumberDtos, LottoMoney lottoMoney, int expectedResult) {
        LottoBill lottoBill = LottoMachine.purchaseLottoTicket(manualNumberDtos, lottoMoney);

        assertThat(lottoBill.getAllTickets().size()).isEqualTo(expectedResult);
    }
}
