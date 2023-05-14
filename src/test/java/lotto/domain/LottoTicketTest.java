package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.factory.LottoNumbersSelectorFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketTest {

  @Test
  @DisplayName("로또 티켓을 생성에 성공한다")
  public void lottoTicketCreateTest() {
    LottoTicket.bySize(6, LottoNumbersRandomSelector.getInstance());
  }

  @Test
  @DisplayName("1등에 대해 성공적으로 계산한다")
  public void firstPlaceScoreTest() {
    LottoTicket ticket = LottoTicket.bySize(6, LottoNumbersSelectorFactory.oneToSix());

    List<LottoNumber> sameSix = LottoNumbersSelectorFactory.oneToSix().selectBy(6);
    LottoNumber bonusNumber = LottoNumbers.pick("8");

    assertThat(ticket.score(sameSix, bonusNumber)).isEqualTo(Winning.FIRST);
  }

  @Test
  @DisplayName("2등에 대해 성공적으로 계산한다")
  public void secondPlaceScoreTest() {
    LottoTicket ticket = LottoTicket.bySize(6, LottoNumbersSelectorFactory.oneToSix());

    List<LottoNumber> firstPlace = LottoNumbersSelectorFactory.oneToFiveAndSeven().selectBy(6);
    LottoNumber bonusNumber = LottoNumbers.pick("6");

    assertThat(ticket.score(firstPlace, bonusNumber)).isEqualTo(Winning.SECOND);
  }

  @Test
  @DisplayName("3등에 대해 성공적으로 계산한다")
  public void thirdPlaceScoreTest() {
    LottoTicket ticket = LottoTicket.bySize(6, LottoNumbersSelectorFactory.oneToSix());

    List<LottoNumber> firstPlace = LottoNumbersSelectorFactory.oneToFiveAndSeven().selectBy(6);
    LottoNumber bonusNumber = LottoNumbers.pick("8");

    assertThat(ticket.score(firstPlace, bonusNumber)).isEqualTo(Winning.THIRD);
  }


}