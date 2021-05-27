package lotto.dto;

import lotto.domain.LottoGame;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.util.TestUtil.createAutoLottoGameFromLottoNumbers;
import static lotto.util.TestUtil.createManualLottoGameFromLottoNumbers;
import static org.assertj.core.api.Assertions.assertThat;

class TotalOrderedLottoGameDescriptionTest {

  private List<LottoGame> givenGames;

  @BeforeEach
  void setUp() {
    givenGames = Lists.newArrayList(createAutoLottoGameFromLottoNumbers("1,2,3,4,5,6"), createManualLottoGameFromLottoNumbers("1,2,3,10,20,30"));
  }

  @DisplayName("주문한 로또 게임들의 갯수를 반환한다.")
  @Test
  void orderedCountTest() {
    //when & then
    assertThat(new TotalOrderedLottoGameDescription(givenGames).getOrderedCountPerOrderType()).isEqualTo("자동으로 1장, 수동으로 1장");
  }

  @DisplayName("주문한 로또 게임들을 정해진 포맷으로 출력한다.")
  @Test
  void toStringTest() {
    //given
    String expectation = "[1, 2, 3, 4, 5, 6]" + System.lineSeparator() + "[1, 2, 3, 10, 20, 30]";

    //when & then
    assertThat(new TotalOrderedLottoGameDescription(givenGames).toString()).hasToString(expectation);
  }

}
