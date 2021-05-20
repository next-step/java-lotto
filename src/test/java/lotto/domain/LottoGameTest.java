package lotto.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.TestUtil.toNumbers;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoGameTest {

  private static LottoNumbers winningNumbers;

  @BeforeAll
  static void setUp() {
    List<LottoNumber> givenNumbers = IntStream.range(1, 7)
        .mapToObj(LottoNumber::new)
        .collect(Collectors.toList());
    winningNumbers = new LottoNumbers(givenNumbers);
  }

  @DisplayName("객체 생성 & 동등성 테스트")
  @Test
  void testConstruct() {
    //when & then
    assertThat(new LottoGame(winningNumbers)).isEqualTo(new LottoGame(winningNumbers));
  }

  @DisplayName("winningNumbers와 일치하는 숫자 개수에 따라 알맞은 등수를 리턴한다.")
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
