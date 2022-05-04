package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import lotto.domain.LottoFactory;
import lotto.domain.LottoResult;
import lotto.domain.LottoStatistics;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketTest {

  @Test
  @DisplayName("로또 티켓 생성")
  void givenLottoNumbers_ShouldCreatedTicket() {
    LottoTicket lottoTicket = LottoFactory.create();
    assertThat(lottoTicket).isNotNull();
  }

  @Test
  @DisplayName("로또 번호 6자리 아닐 경우 예외 처리")
  void givenIllegalSizeNumbers_ShouldException() {
    assertThatIllegalArgumentException().isThrownBy(() -> LottoFactory.create(1, 2, 3, 4, 5));
    assertThatIllegalArgumentException().isThrownBy(() -> LottoFactory.create(1, 2, 3, 4, 5, 6, 7));
  }

  @Test
  @DisplayName("로또 번호 중복 예외 처리")
  void givenIllegalDuplicateNumbers_ShouldException() {
    assertThatIllegalArgumentException().isThrownBy(() -> LottoFactory.create(1, 2, 3, 4, 6, 6));
  }

  @Test
  @DisplayName("로또 1장 결과 확인")
  void givenWinNumbers_ShouldResult() {
    LottoTicket winLottoTicket = LottoFactory.create(1, 2, 3, 4, 5, 6);
    LottoTicket lottoTicket = LottoFactory.create(1, 3, 5, 14, 22, 45);
    assertThat(lottoTicket.getWinLottoNumbers(winLottoTicket)).isEqualTo(new LottoResult(3));
  }

  @Test
  @DisplayName("로또 여러장장 결과 확인")
  void givenWinNumbers_ShouldResultStatistics() {
    LottoTicket winLottoTicket = LottoFactory.create(1, 2, 3, 4, 5, 6);
    LottoTickets lottoTickets = new LottoTickets(List.of(LottoFactory.create(1, 3, 5, 14, 22, 45),
        LottoFactory.create(13, 44, 6, 11, 17, 41)));
    LottoStatistics resultStatistics = lottoTickets.getResultStatistics(winLottoTicket);
    assertThat(resultStatistics.getLottoResults()).contains(new LottoResult(3),
        new LottoResult(1));
  }

}