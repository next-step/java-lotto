package lotto.domain;

import lotto.util.TestUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningConditionsTest {

  @DisplayName("로또 당첨 번호는 보너스 번호를 포함하지 않아야 한다.")
  @Test
  void ofFailTest() {
    //given
    LottoGame givenWinningGame = TestUtil.createLottoGameFromLottoNumbers("1,2,3,4,5,6");
    int givenBonusNumber = 3;

    //when & then
    assertThatThrownBy(() -> WinningConditions.of(givenWinningGame, givenBonusNumber)).isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("당첨 번호와 보너스 번호를 이용해서 입력받은 로또의 등수를 반환한다.")
  @CsvSource(value = {"1,2,3,4,5,6:FIRST", "1,2,3,4,5,7:SECOND", "1,2,3,4,5,8:THIRD", "1,2,3,4,7,8:FOURTH", "1,2,3,8,9,10:FIFTH", "1,2,10,11,12,13:NONE"}, delimiter = ':')
  @ParameterizedTest
  void matchConditions(String givenLottoNumbers, LottoRanking expectation) {
    //given
    LottoGame givenWinningGame = TestUtil.createLottoGameFromLottoNumbers("1,2,3,4,5,6");
    int givenBonusNumber = 7;

    //when
    LottoRanking actual = WinningConditions.of(givenWinningGame, givenBonusNumber).matchConditions(TestUtil.createLottoGameFromLottoNumbers(givenLottoNumbers));
    //then
    assertThat(actual).isSameAs(expectation);
  }
}
