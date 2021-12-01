package lotto.domain.service;

import lotto.domain.entity.Budget;
import lotto.domain.entity.LottoNumber;
import lotto.domain.entity.LottoTicket;
import lotto.domain.entity.LottoTickets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoServiceTest {

  private LottoService lottoService;

  @BeforeEach
  void setUp() {
    lottoService = new LottoService(new AutoMaticLottoTicketCreator());
  }

  @ParameterizedTest
  @CsvSource(value = {"15000:15", "27000:27", "1000:1"}, delimiter = ':')
  @DisplayName("지불한 돈 만큼의 티켓을 구매한다.")
  void buyTheLottoTickets(int budget, int size) {
    assertEquals(lottoService.buyTheLottoTickets(new Budget(budget)).size(), size);
  }

  @ParameterizedTest
  @MethodSource("makeManualList")
  @DisplayName("수동으로 구매한 티켓과 예산을 주었을 때 예산 만큼의 티켓을 구매한다.")
  void buyTheLottoTicketsWithManual(LottoTickets lottoTickets, int budget, int size) {
    assertEquals(lottoService.buyTheLottoTickets(new Budget(budget), lottoTickets).size(), size);
  }

  private static Stream<Arguments> makeManualList() {
    return Stream.of(
            Arguments.of(
                    new LottoTickets(
                            Arrays.asList(
                                    new LottoTicket(
                                            Arrays.asList(
                                                    new LottoNumber(1), new LottoNumber(15), new LottoNumber(40),
                                                    new LottoNumber(25), new LottoNumber(30), new LottoNumber(4))),
                                    new LottoTicket(
                                            Arrays.asList(
                                                    new LottoNumber(4), new LottoNumber(10), new LottoNumber(26),
                                                    new LottoNumber(35), new LottoNumber(45), new LottoNumber(12))))),
                    14000, 14));
  }
}