package lotto.dto;

import lotto.domain.LottoGame;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.util.TestUtil.createLottoGameFromLottoNumbers;
import static org.assertj.core.api.Assertions.assertThat;

class OrderedInfosTest {

  private List<LottoGame> givenGames;

  @BeforeEach
  void setUp() {
    givenGames = Lists.newArrayList(createLottoGameFromLottoNumbers("1,2,3,4,5,6"), createLottoGameFromLottoNumbers("1,2,3,10,20,30"));
  }

  @DisplayName("객체 생성 & 동등성 테스트")
  @Test
  void constructionAndEqualityTest() {
    assertThat(new OrderedInfos(givenGames)).isEqualTo(new OrderedInfos(givenGames));
  }

  @DisplayName("주문한 게임 갯수 반환 테스트")
  @Test
  void orderedCountTest() {
    //when & then
    assertThat(new OrderedInfos(givenGames).orderedCount()).isEqualTo(2);
  }

  @DisplayName("toString 값 테스트")
  @Test
  void toStringTest() {
    //given
    String expectation = "[1, 2, 3, 4, 5, 6]" + System.lineSeparator() + "[1, 2, 3, 10, 20, 30]";

    //when & then
    assertThat(new OrderedInfos(givenGames).toString()).hasToString(expectation);
  }

}
