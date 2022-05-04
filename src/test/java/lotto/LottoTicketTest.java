package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketTest {

  @Test
  @DisplayName("로또 티켓 생성")
  void givenLottoNumbers_ShouldCreatedTicket() {
    LottoTicket lottoTicket = new LottoTicket(LottoFactory.create());
    assertThat(lottoTicket).isNotNull();
  }

  @Test
  @DisplayName("로또 번호 6자리 아닐 경우 예외 처리")
  void givenIllegalSizeNumbers_ShouldException() {
    assertThatIllegalArgumentException().isThrownBy(() ->
        new LottoTicket(
            List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4),
                new LottoNumber(5))));
    assertThatIllegalArgumentException().isThrownBy(() ->
        new LottoTicket(
            List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4),
                new LottoNumber(5), new LottoNumber(6), new LottoNumber(7))));
  }

  @Test
  @DisplayName("로또 번호 중복 예외 처리")
  void givenIllegalDuplicateNumbers_ShouldException() {
    assertThatIllegalArgumentException().isThrownBy(() ->
        new LottoTicket(
            List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4),
                new LottoNumber(6), new LottoNumber(6))));
  }

  @Test
  @DisplayName("로또 1장 결과 확인")
  void givenWinNumbers_ShouldResult() {
    LottoTicket winLottoTicket = new LottoTicket(List.of(new LottoNumber(1), new LottoNumber(2),
        new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));

    LottoTicket lottoTicket = new LottoTicket(
        List.of(new LottoNumber(1), new LottoNumber(3), new LottoNumber(5), new LottoNumber(14),
            new LottoNumber(22), new LottoNumber(45)));

    assertThat(lottoTicket.getWinLottoNumbers(winLottoTicket)).isEqualTo(new LottoResult(3));
  }

  @Test
  @DisplayName("로또 여러장장 결과 확인")
  void givenWinNumbers_ShouldResultStatistics() {
    LottoTicket winLottoTicket = new LottoTicket(List.of(new LottoNumber(1), new LottoNumber(2),
        new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));
    LottoTickets lottoTickets = new LottoTickets(
        List.of(
            new LottoTicket(List.of(new LottoNumber(1), new LottoNumber(3), new LottoNumber(5),
                new LottoNumber(14), new LottoNumber(22), new LottoNumber(45))),
            new LottoTicket(List.of(new LottoNumber(13), new LottoNumber(44), new LottoNumber(6),
                new LottoNumber(11), new LottoNumber(17), new LottoNumber(41)))
        )
    );
    LottoStatistics resultStatistics = lottoTickets.getResultStatistics(winLottoTicket);
    assertThat(resultStatistics.getLottoResultList()).contains(new LottoResult(3),
        new LottoResult(1));
  }

}