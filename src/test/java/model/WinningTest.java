package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class WinningTest {

  @Test
  void 보너스볼당첨갯수와수익률을구한다() {
    Lottos lottos = new Lottos(Arrays.asList(
        makeLotto(1, 2, 3, 4, 5, 6)
    ));
    WinningNumbers winningNumbers = new WinningNumbers("1, 2, 3, 4, 5, 7");
    BonusBall bonusBall = new BonusBall(winningNumbers, 6);
    MatchesStatus matchesStatus = lottos.findWinner(winningNumbers, bonusBall);
    assertAll(
        () -> assertThat(matchesStatus.getThreeMatches()).isEqualTo(0), // 5000원
        () -> assertThat(matchesStatus.getFourMatches()).isEqualTo(0), // 50000원
        () -> assertThat(matchesStatus.getFiveMatches()).isEqualTo(0), // 1500000원
        () -> assertThat(matchesStatus.getFiveAndBonusMatches()).isEqualTo(1), // 30000000원
        () -> assertThat(matchesStatus.getSixMatches()).isEqualTo(0), // 2000000000원
        () -> assertThat(matchesStatus.findRateOfReturn(lottos)).isEqualTo(new BigDecimal("30000.00"))
    );
  }

  @Test
  void 중복된보너스볼을입력한다() {
    assertThatIllegalArgumentException().isThrownBy(() -> {
      new BonusBall(new WinningNumbers("1,2,3,4,5,6"), 3);
    });
  }

  @Test
  void 보너스볼을입력한다() {
    BonusBall bonusBall = new BonusBall(new WinningNumbers("1,2,3,4,5,6"), 7);
    assertThat(bonusBall.getBonusNumber()).isEqualTo(LottoNo.of(7));
  }

  @Test
  void 수익률을구하고_일치하는갯수를찾는다1() {
    Lottos lottos = new Lottos(
        Arrays.asList(
            makeLotto(1, 2, 3, 4, 5, 6), makeLotto_11_12_13_15_18_19(),
            makeLotto_11_12_13_15_18_19(), makeLotto_11_12_13_15_18_19(),
            makeLotto_11_12_13_15_18_19(), makeLotto_11_12_13_15_18_19(),
            makeLotto_11_12_13_15_18_19(), makeLotto_11_12_13_15_18_19(),
            makeLotto_11_12_13_15_18_19(), makeLotto_11_12_13_15_18_19(),
            makeLotto_11_12_13_15_18_19(), makeLotto_11_12_13_15_18_19(),
            makeLotto_11_12_13_15_18_19(), makeLotto_11_12_13_15_18_19()));
    WinningNumbers winningNumbers = new WinningNumbers("1, 2, 3, 44, 43, 42");
    MatchesStatus matchesStatus = lottos.findWinner(winningNumbers, new BonusBall(winningNumbers, 22));
    assertAll(
        () -> assertThat(matchesStatus.getThreeMatches()).isEqualTo(1), // 5000원
        () -> assertThat(matchesStatus.getFourMatches()).isEqualTo(0), // 50000원
        () -> assertThat(matchesStatus.getFiveMatches()).isEqualTo(0), // 1500000원
        () -> assertThat(matchesStatus.getSixMatches()).isEqualTo(0), // 2000000000원
        () -> assertThat(matchesStatus.findRateOfReturn(lottos)).isEqualTo(new BigDecimal("0.35"))
    );
  }

  @Test
  void 수익률을구하고_일치하는갯수를찾는다2() {
    Lottos lottos = new Lottos(Arrays.asList(
        makeLotto(1, 2, 3, 4, 5, 6),
        makeLotto(1, 2, 3, 5, 8, 9),
        makeLotto(1, 2, 3, 10, 11, 12),
        makeLotto(1, 2, 15, 16, 11, 12),
        makeLotto(1, 2, 3, 4, 5, 6)
    ));
    WinningNumbers winningNumbers = new WinningNumbers("1, 2, 3, 4, 5, 6");
    MatchesStatus matchesStatus = lottos.findWinner(winningNumbers, new BonusBall(winningNumbers, 22));
    assertAll(
        () -> assertThat(matchesStatus.getThreeMatches()).isEqualTo(1), // 5000원
        () -> assertThat(matchesStatus.getFourMatches()).isEqualTo(1), // 50000원
        () -> assertThat(matchesStatus.getFiveMatches()).isEqualTo(0), // 1500000원
        () -> assertThat(matchesStatus.getSixMatches()).isEqualTo(2), // 2000000000원
        () -> assertThat(matchesStatus.findRateOfReturn(lottos)).isEqualTo(new BigDecimal("800011.00"))
    );
  }

  private AutoLotto makeLotto_11_12_13_15_18_19() {
    return makeLotto(11, 12, 13, 15, 18, 19);
  }

  private AutoLotto makeLotto(int value1, int value2, int value3, int value4, int value5, int value6) {
    return makeLotto(Arrays.asList(value1, value2, value3, value4, value5, value6));
  }

  private AutoLotto makeLotto(List<Integer> inputLotto) {
    Set<LottoNo> lotto = new HashSet<>();
    for (Integer number : inputLotto) {
      lotto.add(LottoNo.of(number));
    }
    return new AutoLotto(lotto);
  }

  @Test
  void 당첨번호를입력하면일치하는갯수를찾는다() {
    AutoLotto lotto = makeLotto(1, 2, 3, 4, 5, 6);

    WinningNumbers winningNumbers = new WinningNumbers("1, 2, 3, 44, 33, 22");

    assertThat(lotto.countMatchesNumber(winningNumbers)).isEqualTo(3);
  }

  @Test
  void 당첨번호는중복된숫자를입력하지말아야한다() {
    assertThatIllegalArgumentException().isThrownBy(() -> {
      new WinningNumbers("1, 2, 2, 4, 5, 6");
    });
  }

  @Test
  void 당첨번호는6개를입력해야한다() {
    assertThatIllegalArgumentException().isThrownBy(() -> {
      new WinningNumbers("1, 2, 3, 4, 5");
    });
  }

}
