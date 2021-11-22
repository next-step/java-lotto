package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Arrays;
import java.util.stream.Stream;
import lotto.domain.LottoTickets;
import lotto.domain.dto.WinningLottoTicketDto;
import lotto.exception.MinimumAmountException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoServiceTest {

    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = LottoService.getInstance();
    }

    @ParameterizedTest
    @DisplayName("로또자동생성성공")
    @CsvSource(value = {"14000:14", "10000:10", "1000:1"}, delimiter = ':')
    void autoCreate(int money, int size) {
        assertThat(lottoService.autoTickets(money).size()).isEqualTo(size);
    }

    @ParameterizedTest
    @DisplayName("로또 금액 부족 예외처리")
    @ValueSource(ints = {900, 100, 0})
    void LackOfMoneyException(Integer money) {
        assertThatExceptionOfType(MinimumAmountException.class)
            .isThrownBy(() -> lottoService.autoTickets(money));

    }

    static Stream<Arguments> generateWinningLottoTicket() {
        String winnerLottoTicket = "1, 2, 3, 4, 5, 6";
        LottoTickets lottoTickets = new LottoTickets();
        lottoTickets = lottoTickets.add(Arrays.asList(8, 21, 23, 41, 42, 43));
        lottoTickets = lottoTickets.add(Arrays.asList(3, 5, 11, 16, 32, 38));
        lottoTickets = lottoTickets.add(Arrays.asList(7, 11, 16, 35, 36, 44));
        lottoTickets = lottoTickets.add(Arrays.asList(1, 8, 11, 31, 41, 42));
        lottoTickets = lottoTickets.add(Arrays.asList(13, 14, 16, 38, 42, 45));
        lottoTickets = lottoTickets.add(Arrays.asList(2, 13, 22, 32, 38, 45));
        lottoTickets = lottoTickets.add(Arrays.asList(23, 25, 33, 36, 39, 41));
        lottoTickets = lottoTickets.add(Arrays.asList(1, 3, 5, 14, 22, 45));
        lottoTickets = lottoTickets.add(Arrays.asList(5, 9, 38, 41, 43, 44));
        lottoTickets = lottoTickets.add(Arrays.asList(2, 8, 9, 18, 19, 21));
        lottoTickets = lottoTickets.add(Arrays.asList(13, 14, 18, 21, 23, 35));
        lottoTickets = lottoTickets.add(Arrays.asList(17, 21, 29, 37, 42, 45));
        lottoTickets = lottoTickets.add(Arrays.asList(3, 8, 27, 30, 35, 44));
        lottoTickets = lottoTickets.add(Arrays.asList(7, 11, 30, 40, 42, 43));

        return Stream.of(
            Arguments.of(new WinningLottoTicketDto(lottoTickets, winnerLottoTicket), 0.35d)
        );
    }

    @ParameterizedTest
    @MethodSource("generateWinningLottoTicket")
    void winningResult(WinningLottoTicketDto dto, Double yield) {
        assertThat(lottoService.winningResult(dto).getYield()).isEqualTo(yield);
    }

}
