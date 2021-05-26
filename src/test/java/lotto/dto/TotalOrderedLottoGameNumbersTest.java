package lotto.dto;

import lotto.domain.LottoGame;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.util.TestUtil.createAutoLottoGameFromLottoNumbers;
import static org.assertj.core.api.Assertions.assertThat;

class TotalOrderedLottoGameNumbersTest {

  private List<LottoGame> givenGames;

  @BeforeEach
  void setUp() {
    givenGames = Lists.newArrayList(createAutoLottoGameFromLottoNumbers("1,2,3,4,5,6"), createAutoLottoGameFromLottoNumbers("1,2,3,10,20,30"));
  }

  @DisplayName("주문한 로또 게임들의 갯수를 반환한다.")
  @Test
  void orderedCountTest() {
    //when & then
    assertThat(new TotalOrderedLottoGameNumbers(givenGames).getOrderedCount()).isEqualTo(2);
  }

  @DisplayName("주문한 로또 게임들을 정해진 포맷으로 출력한다.")
  @Test
  void toStringTest() {
    //given
    String expectation = "[1, 2, 3, 4, 5, 6]" + System.lineSeparator() + "[1, 2, 3, 10, 20, 30]";

    //when & then
    assertThat(new TotalOrderedLottoGameNumbers(givenGames).toString()).hasToString(expectation);
  }

}
