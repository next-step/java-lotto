package lotto.domain.service;

import lotto.domain.entity.Budget;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
}