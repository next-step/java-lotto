package lotto.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.util.TestUtil.getOneToSixLottoNumbers;
import static lotto.util.TestUtil.toNumbers;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoGameTest {

  private static LottoNumbers winningNumbers;

  @BeforeAll
  static void setUp() {
    winningNumbers = new LottoNumbers(getOneToSixLottoNumbers());
  }

  @DisplayName("당첨 번호와 일치하는 갯수에 해당하는 등수를 반환한다.")
  @Test
  void checkWinningTest() {
    //given
    LottoNumbers firstNumbers = new LottoNumbers(toNumbers("1,2,3,4,5,6"));
    LottoNumbers secondNumbers = new LottoNumbers(toNumbers("1,2,3,4,5,7"));
    LottoNumbers thirdNumbers = new LottoNumbers(toNumbers("1,2,3,4,7,8"));
    LottoNumbers fourthNumbers = new LottoNumbers(toNumbers("1,2,3,7,8,9"));
    LottoNumbers noneNumbers = new LottoNumbers(toNumbers("1,2,7,8,9,10"));
    assertAll(
        () -> assertThat(new LottoGame(firstNumbers).checkWinning(new LottoGame(winningNumbers))).isSameAs(LottoRanking.FIRST),
        () -> assertThat(new LottoGame(secondNumbers).checkWinning(new LottoGame(winningNumbers))).isSameAs(LottoRanking.SECOND),
        () -> assertThat(new LottoGame(thirdNumbers).checkWinning(new LottoGame(winningNumbers))).isSameAs(LottoRanking.THIRD),
        () -> assertThat(new LottoGame(fourthNumbers).checkWinning(new LottoGame(winningNumbers))).isSameAs(LottoRanking.FOURTH),
        () -> assertThat(new LottoGame(noneNumbers).checkWinning(new LottoGame(winningNumbers))).isSameAs(LottoRanking.NONE)
    );
  }
}
