package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGameTest {

  @Test
  @DisplayName("로또 구매 금액을 입력하면 구매가능한 로또 장수를 반환한다.")
  void givenMoney_ShouldBeLottoTicketCount() {
    assertThat(LottoGame.toTicketCount(Money.from(9100))).isEqualTo(9);
  }

  @Test
  @DisplayName("로또 1등")
  void givenLotto_shouldBeTopLottoRank() {
    List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
    List<Integer> winLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
    assertThat(LottoGame.match(lottoNumbers, winLottoNumbers, 7)).isEqualTo(Rank.TOP);
  }

  @Test
  @DisplayName("로또 2등")
  void givenLotto_shouldBeSecondLottoRank() {
    List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 7);
    List<Integer> winLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
    assertThat(LottoGame.match(lottoNumbers, winLottoNumbers, 7)).isEqualTo(Rank.SECOND);
  }
}