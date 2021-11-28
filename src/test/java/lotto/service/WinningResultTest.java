package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTicketFactory;
import lotto.domain.LottoTickets;
import lotto.domain.dto.WinningNumberDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class WinningResultTest {

    private WinningResult winningResult;

    @BeforeEach
    void setUp() {
        winningResult = WinningResult.getInstance();
    }

    static Stream<Arguments> generateWinningLottoTicket() {
        WinningNumberDto winnerNumberDto = WinningNumberDto.from("1, 2, 3, 4, 5, 6", 7);

        List<String> manualLottoNumbers = new ArrayList<>();
        manualLottoNumbers.add("8, 21, 23, 41, 42, 43");
        manualLottoNumbers.add("3, 5, 11, 16, 32, 38");
        manualLottoNumbers.add("7, 11, 16, 35, 36, 44");
        manualLottoNumbers.add("1, 8, 11, 31, 41, 42");
        manualLottoNumbers.add("13, 14, 16, 38, 42, 45");
        manualLottoNumbers.add("2, 13, 22, 32, 38, 45");
        manualLottoNumbers.add("23, 25, 33, 36, 39, 41");
        manualLottoNumbers.add("1, 3, 5, 14, 22, 45");
        manualLottoNumbers.add("5, 9, 38, 41, 43, 44");
        manualLottoNumbers.add("2, 8, 9, 18, 19, 21");
        manualLottoNumbers.add("13, 14, 18, 21, 23, 35");
        manualLottoNumbers.add("17, 21, 29, 37, 42, 45");
        manualLottoNumbers.add("3, 8, 27, 30, 35, 44");
        manualLottoNumbers.add("7, 11, 30, 40, 42, 43");

        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (String manualLottoNumber : manualLottoNumbers) {
            lottoTickets.add(LottoTicket.from(LottoTicketFactory
                .LottoTicketFactory(manualLottoNumber)
                .createLottoNumber()));
        }
        LottoTickets argumentLottoTickets = new LottoTickets(lottoTickets);

        return Stream.of(
            Arguments.of(argumentLottoTickets, winnerNumberDto, 0.35d)
        );
    }

    @ParameterizedTest
    @MethodSource("generateWinningLottoTicket")
    @DisplayName("수익률 계산")
    void yield(LottoTickets lottoTickets, WinningNumberDto winnerNumberDto, Double yield) {
        assertThat(winningResult.winningResult(lottoTickets, winnerNumberDto).getRate()).isEqualTo(yield);
    }

}
