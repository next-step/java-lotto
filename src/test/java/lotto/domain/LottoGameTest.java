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
  @CsvSource(value = {"1,2,3,4,5,6:6", "1,2,3,4,5,7:5", "1,2,3,4,7,8:4", "1,2,3,7,8,9:3"}, delimiter = ':')
  @ParameterizedTest
  void matchWinningNumbersTest(String givenNumbers, int expectation) {
    //given
    LottoNumbers givenLottoNumbers = new LottoNumbers(toNumbers(givenNumbers));
    //when & then
    assertThat(LottoGame.createAutoGame(givenLottoNumbers).matchWinningNumbers(LottoGame.createManualGame(winningNumbers)))
        .isEqualTo(expectation);
  }

  @DisplayName("보너스 번호를 포함하고 있는지 여부를 반환한다.")
  @CsvSource(value = {"1,true", "6,true", "7,false"})
  @ParameterizedTest
  void matchBonusNumberTest(int givenBonusNumber, boolean expectation) {
    assertThat(LottoGame.createAutoGame(winningNumbers).matchBonusNumber(new LottoNumber(givenBonusNumber))).isEqualTo(expectation);
  }

  @DisplayName("자동 생성된 로또인지, 수동 생성된 로또인지 반환한다.")
  @Test
  void orderTypeReturnTest() {
    assertAll(
        () -> assertThat(LottoGame.createAutoGame(winningNumbers).getOrderTypeName()).isEqualTo(OrderType.AUTO.getDisplayName()),
        () -> assertThat(LottoGame.createManualGame(winningNumbers).getOrderTypeName()).isEqualTo(OrderType.MANUAL.getDisplayName())
    );
  }

}
