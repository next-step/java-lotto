package lotto.domain;

import static lotto.domain.LottoNumbers.pick;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningTest {

  LottoNumbersSelector manualSelector = number -> new ArrayList<>(List.of(pick("1"), pick("2"),
      pick("3"), pick("4"), pick("5"), pick("6")));

  List sixSameNumbers = List.of(pick("1"), pick("2"), pick("3"), pick("4"),
      pick("5"), pick("6"));

  List fiveSameNumbers = List.of(pick("1"), pick("2"), pick("3"), pick("4"),
      pick("5"), pick("7"));

  @Test
  @DisplayName("6개 번호가 일치하면 1등에 당첨된다")
  void firstPriceTest() {
    Map<Winning, Integer> score = Winning.score(LottoTickets.issue(1, manualSelector), sixSameNumbers,
        pick("7"));

    Assertions.assertThat(score.get(Winning.FIRST)).isEqualTo(1);
  }

  @Test
  @DisplayName("5개 번호가 일치하고, 보너스 번호가 일치하면 2등에 당첨된다")
  void secondPriceTest() {
    Map<Winning, Integer> score = Winning.score(LottoTickets.issue(1, manualSelector), fiveSameNumbers,
        pick("6"));

    Assertions.assertThat(score.get(Winning.SECOND)).isEqualTo(1);
  }

  @Test
  @DisplayName("5개 번호가 일치하고, 보너스 번호가 일치하지 않으면 3등에 당첨된다")
  void thirdPriceTest() {
    Map<Winning, Integer> score = Winning.score(LottoTickets.issue(1, manualSelector), fiveSameNumbers,
        pick("8"));

    Assertions.assertThat(score.get(Winning.THIRD)).isEqualTo(1);
  }


}