package step2.domain.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.Number;
import step2.domain.UserLotto;
import step2.domain.WinningLotto;
import step2.enums.Rank;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

  private UserLotto makeUserLotto(String input) {
    WinningLotto winningLotto = new WinningLotto("1,2,3,7,8,9");
    return new UserLotto(Arrays.stream(input.split(","))
        .map(Number::new)
        .collect(Collectors.toList()), winningLotto);
  }

  @DisplayName("아무것도 맞지 않을 경우")
  @Test
  void constructorTest_non_match() {
    // winnig 1,2,3,7,8,9
    List<UserLotto> userLottoList = Arrays.asList(
        makeUserLotto("11,12,13,14,15,16"),
        makeUserLotto("24,25,26,27,28,28"),
        makeUserLotto("15,17,18,24,28,31"));
    LottoResult result = new LottoResult(userLottoList, 5000, new Number(45));

    assertThat(result.getMatchResultMap().get(Rank.FIFTH)).isEqualTo(null);
    assertThat(result.getMatchResultMap().get(Rank.FOURTH)).isEqualTo(null);
    assertThat(result.getMatchResultMap().get(Rank.THIRD)).isEqualTo(null);
    assertThat(result.getMatchResultMap().get(Rank.FIRST)).isEqualTo(null);
    assertThat(result.getEarningRate()).isEqualTo(0.0);
  }

  @DisplayName("3개 매치가 2건")
  @Test
  void constructorTest_partial_match() {
    // winnig 1,2,3,7,8,9
    List<UserLotto> userLottoList = Arrays.asList(
        makeUserLotto("1,2,3,4,5,6"), // 1,2,3
        makeUserLotto("4,5,6,7,8,9"), // 7,8,9
        makeUserLotto("10,13,15,18,19,30"),
        makeUserLotto("13,24,36,40,41,45"),
        makeUserLotto("15,17,18,24,28,31"));
    LottoResult result = new LottoResult(userLottoList, 5000, new Number(45));

    assertThat(result.getMatchResultMap().get(Rank.FIFTH)).isEqualTo(2);
    assertThat(result.getMatchResultMap().get(Rank.FOURTH)).isEqualTo(null);
    assertThat(result.getMatchResultMap().get(Rank.THIRD)).isEqualTo(null);
    assertThat(result.getMatchResultMap().get(Rank.FIRST)).isEqualTo(null);
    assertThat(result.getEarningRate()).isEqualTo(2.0);
  }

  @DisplayName("1등 당첨(모두 매치)")
  @Test
  void constructorTest_all_match() {
    // winnig 1,2,3,7,8,9
    List<UserLotto> userLottoList = Arrays.asList(
        makeUserLotto("1,2,3,7,8,9"), // 1,2,3,7,8,9
        makeUserLotto("24,25,26,27,28,28"),
        makeUserLotto("10,13,15,18,19,30"),
        makeUserLotto("13,24,36,40,41,45"),
        makeUserLotto("15,17,18,24,28,31"));
    LottoResult result = new LottoResult(userLottoList, 5000, new Number(1));

    assertThat(result.getMatchResultMap().get(Rank.FIFTH)).isEqualTo(null);
    assertThat(result.getMatchResultMap().get(Rank.FOURTH)).isEqualTo(null);
    assertThat(result.getMatchResultMap().get(Rank.THIRD)).isEqualTo(null);
    assertThat(result.getMatchResultMap().get(Rank.FIRST)).isEqualTo(1);
    assertThat(result.getEarningRate()).isEqualTo(400000.0);
  }

  @DisplayName("보너스 번호가 5개 외에 추가로 일치한다면, 2등으로 카운트한다.")
  @Test
  void bonusNoTest() {
    // winnig 1,2,3,7,8,9
    int bonusNo = 10;
    List<UserLotto> userLottoList = Arrays.asList(
        makeUserLotto("1,2,3,7,8,10"), // 기본 5개 일치 + bonus 1건 일치
        makeUserLotto("24,25,26,27,28,28"),
        makeUserLotto("10,13,15,18,19,30"),
        makeUserLotto("13,24,36,40,41,45"),
        makeUserLotto("15,17,18,24,28,31"));
    LottoResult result = new LottoResult(userLottoList, 5000, new Number(bonusNo));
    assertThat(result.getMatchResultMap().get(Rank.THIRD)).isEqualTo(null);
    assertThat(result.getMatchResultMap().get(Rank.SECOND)).isEqualTo(1);
    assertThat(result.getEarningRate()).isEqualTo(6000.0);
  }
}
