package lotto.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

  @DisplayName("당첨 번호와 일치하는 갯수를 반환한다.")
  @Test
  void matchWinningNumbersTest() {
    //given
    LottoNumbers firstNumbers = new LottoNumbers(toNumbers("1,2,3,4,5,6"));
    LottoNumbers secondNumbers = new LottoNumbers(toNumbers("1,2,3,4,5,7"));
    LottoNumbers thirdNumbers = new LottoNumbers(toNumbers("1,2,3,4,7,8"));
    LottoNumbers fourthNumbers = new LottoNumbers(toNumbers("1,2,3,7,8,9"));
    assertAll(
        () -> assertThat(new LottoGame(firstNumbers).matchWinningNumbers(new LottoGame(winningNumbers))).isEqualTo(6),
        () -> assertThat(new LottoGame(secondNumbers).matchWinningNumbers(new LottoGame(winningNumbers))).isEqualTo(5),
        () -> assertThat(new LottoGame(thirdNumbers).matchWinningNumbers(new LottoGame(winningNumbers))).isEqualTo(4),
        () -> assertThat(new LottoGame(fourthNumbers).matchWinningNumbers(new LottoGame(winningNumbers))).isEqualTo(3)
    );
  }

  @DisplayName("보너스 번호를 포함하고 있는지 여부를 반환한다.")
  @CsvSource(value = {"1,true", "6,true", "7,false"})
  @ParameterizedTest
  void matchBonusNumberTest(int givenBonusNumber, boolean expectation) {
    assertThat(new LottoGame(winningNumbers).matchBonusNumber(new LottoNumber(givenBonusNumber))).isEqualTo(expectation);
  }

}
