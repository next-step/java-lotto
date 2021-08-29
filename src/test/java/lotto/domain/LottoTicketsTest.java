package lotto.domain;

import lotto.util.StringUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottoTicketsTest {

    @DisplayName("로또 티켓 구매")
    @ParameterizedTest(name = "{index}. {displayName}, arguments: {arguments}")
    @MethodSource("parameterProvider")
    void buy(String[] inputManualTickets, TicketCount autoTicketCount) {
        LottoTickets lottoTickets = LottoTickets.init(inputManualTickets, autoTicketCount);
        List<LottoNumbers> manualLottoTickets = Arrays.stream(inputManualTickets)
                .map(manualLottoNumbers -> new LottoNumbers(StringUtil.split(manualLottoNumbers)))
                .collect(toList());

        assertAll(
                () -> assertThat(lottoTickets.getLottoTickets()).hasSize(inputManualTickets.length + autoTicketCount.getValue()),
                () -> assertThat(lottoTickets.getAutoTicketCount()).isEqualTo(autoTicketCount.getValue()),
                () -> assertThat(lottoTickets.getManualTicketCount()).isEqualTo(inputManualTickets.length),
                () -> assertThat(lottoTickets.getLottoTickets()).containsAll(manualLottoTickets)
        );
    }

    //구매금액, 수동 로또 배열
    static Stream<Arguments> parameterProvider() {
        return Stream.of(
                Arguments.of(new String[]{"6, 13, 20, 28, 35, 41", "3, 14, 22, 33, 39, 40", "1, 9, 21, 30, 35, 44"}, new TicketCount(5)),
                Arguments.of(new String[0], new TicketCount(10)),
                Arguments.of(new String[]{"6, 13, 20, 28, 35, 41", "3, 14, 22, 33, 39, 40", "1, 9, 21, 30, 35, 44"}, new TicketCount(0))
        );
    }
}
