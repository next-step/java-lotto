package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketTest {

  @Test
  @DisplayName("로또 티켓 생성")
  void givenLottoNumbers_ShouldCreatedTicket() {
    LottoTicket lottoTicket = LottoFactory.createAuto();
    assertThat(lottoTicket).isNotNull();
  }

  @Test
  @DisplayName("로또 번호 6자리 아닐 경우 예외 처리")
  void givenIllegalSizeNumbers_ShouldException() {
    assertThatIllegalArgumentException().isThrownBy(() -> LottoFactory.createManual("1,2,3,4,5"));
    assertThatIllegalArgumentException().isThrownBy(() -> LottoFactory.createManual("1,2,3,4,5,6,7"));
  }

  @Test
  @DisplayName("로또 번호 중복 예외 처리")
  void givenIllegalDuplicateNumbers_ShouldException() {
    assertThatIllegalArgumentException().isThrownBy(() -> LottoFactory.createManual("1,2,3,4,6,6"));
  }

  @Test
  @DisplayName("로또 1장 결과 확인")
  void givenWinNumbers_ShouldResult() {
    WinLotto winLotto = new WinLotto(LottoFactory.createManual("1,2,3,4,5,6"),
        LottoNumber.from(9));
    LottoTicket lottoTicket = LottoFactory.createManual("1,3,5,14,22,45");
    assertThat(lottoTicket.getWinLottoNumbers(winLotto)).isEqualTo(LottoRank.FIFTH);
  }

  @Test
  @DisplayName("로또 여러장 결과 확인")
  void givenWinNumbers_ShouldResultStatistics() {
    WinLotto winLotto = new WinLotto(LottoFactory.createManual("1,2,3,4,5,6"),
        LottoNumber.from(9));
    Lotto lotto = new Lotto(List.of(LottoFactory.createManual("1,3,5,14,22,45"),
        LottoFactory.createManual("13,44,6,11,17,41")));
    LottoResult resultStatistics = lotto.result(winLotto);
    assertThat(resultStatistics.getLottoResults()).contains(LottoRank.FIFTH, LottoRank.NONE);
  }

  @Test
  @DisplayName("로또 1등 결과 확인")
  void givenWinNumbers_ShouldTopRank() {
    WinLotto winLotto = new WinLotto(LottoFactory.createManual("1,2,3,4,5,6"),
        LottoNumber.from(9));
    LottoTicket lottoTicket = LottoFactory.createManual("1,2,3,4,5,6");
    assertThat(lottoTicket.getWinLottoNumbers(winLotto)).isEqualTo(LottoRank.TOP);
  }

  @Test
  @DisplayName("로또 2등 결과 확인")
  void givenWinNumbers_ShouldSecondRank() {
    WinLotto winLotto = new WinLotto(LottoFactory.createManual("1,2,3,4,5,6"),
        LottoNumber.from(9));
    LottoTicket lottoTicket = LottoFactory.createManual("1,2,3,4,5,9");
    assertThat(lottoTicket.getWinLottoNumbers(winLotto)).isEqualTo(LottoRank.SECOND);
  }

  @Test
  @DisplayName("로또 3등 결과 확인")
  void givenWinNumbers_ShouldThirdRank() {
    WinLotto winLotto = new WinLotto(LottoFactory.createManual("1,2,3,4,5,6"),
        LottoNumber.from(10));
    LottoTicket lottoTicket = LottoFactory.createManual("1,2,3,4,5,9");
    assertThat(lottoTicket.getWinLottoNumbers(winLotto)).isEqualTo(LottoRank.THIRD);
  }

}
