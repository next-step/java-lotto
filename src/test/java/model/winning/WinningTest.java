package model.winning;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import model.lotto.AutoLotto;
import model.lotto.LottoNo;
import model.lotto.Lottos;
import model.lotto.ManualLotto;
import org.junit.jupiter.api.Test;

public class WinningTest {

  @Test
  void 보너스볼당첨갯수와수익률을구한다_수동() {
    // given
    Lottos lottos = new Lottos();
    lottos.addManualLotto(makeManualLotto(1, 2, 3, 4, 5, 6));

    // when
    WinningNumbers winningNumbers = new WinningNumbers("1, 2, 3, 4, 5, 7");
    BonusBall bonusBall = new BonusBall(winningNumbers, 6);

    // then
    MatchesStatus matchesStatus = lottos.findWinner(winningNumbers, bonusBall);
    assertAll(
        () -> assertThat(matchesStatus.getThreeMatches()).isEqualTo(0), // 5000원
        () -> assertThat(matchesStatus.getFourMatches()).isEqualTo(0), // 50000원
        () -> assertThat(matchesStatus.getFiveMatches()).isEqualTo(0), // 1500000원
        () -> assertThat(matchesStatus.getFiveAndBonusMatches()).isEqualTo(1), // 30000000원
        () -> assertThat(matchesStatus.getSixMatches()).isEqualTo(0), // 2000000000원
        () -> assertThat(matchesStatus.findRateOfReturn(lottos)).isEqualTo(
            new BigDecimal("30000.00"))
    );
  }

  @Test
  void 보너스볼당첨갯수와수익률을구한다_자동() {
    // given
    Lottos lottos = new Lottos(List.of(
        makeAutoLotto(1, 2, 3, 4, 5, 6)
    ));

    //when
    WinningNumbers winningNumbers = new WinningNumbers("1, 2, 3, 4, 5, 7");
    BonusBall bonusBall = new BonusBall(winningNumbers, 6);

    //then
    MatchesStatus matchesStatus = lottos.findWinner(winningNumbers, bonusBall);
    assertAll(
        () -> assertThat(matchesStatus.getThreeMatches()).isEqualTo(0), // 5000원
        () -> assertThat(matchesStatus.getFourMatches()).isEqualTo(0), // 50000원
        () -> assertThat(matchesStatus.getFiveMatches()).isEqualTo(0), // 1500000원
        () -> assertThat(matchesStatus.getFiveAndBonusMatches()).isEqualTo(1), // 30000000원
        () -> assertThat(matchesStatus.getSixMatches()).isEqualTo(0), // 2000000000원
        () -> assertThat(matchesStatus.findRateOfReturn(lottos)).isEqualTo(
            new BigDecimal("30000.00"))
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
  void 수익률을구하고_일치하는갯수를찾는다_수동_자동() {
    // given
    Lottos lottos = new Lottos(
        Arrays.asList(
            makeAutoLotto(1, 2, 3, 4, 5, 6), makeAutoLotto_11_12_13_15_18_19(),
            makeAutoLotto_11_12_13_15_18_19(), makeAutoLotto_11_12_13_15_18_19(),
            makeAutoLotto_11_12_13_15_18_19(), makeAutoLotto_11_12_13_15_18_19(),
            makeAutoLotto_11_12_13_15_18_19()));
    for (int i = 0; i < 7; i++) {
      lottos.addManualLotto(makeManualLotto_11_12_13_15_18_19());
    }

    // when
    WinningNumbers winningNumbers = new WinningNumbers("1, 2, 3, 44, 43, 42");
    MatchesStatus matchesStatus = lottos.findWinner(winningNumbers,
        new BonusBall(winningNumbers, 22));

    // then
    assertAll(
        () -> assertThat(lottos.getAutoLottos()).hasSize(7),
        () -> assertThat(lottos.getManualLottos()).hasSize(7),
        () -> assertThat(matchesStatus.getThreeMatches()).isEqualTo(1), // 5000원
        () -> assertThat(matchesStatus.getFourMatches()).isEqualTo(0), // 50000원
        () -> assertThat(matchesStatus.getFiveMatches()).isEqualTo(0), // 1500000원
        () -> assertThat(matchesStatus.getSixMatches()).isEqualTo(0), // 2000000000원
        () -> assertThat(matchesStatus.findRateOfReturn(lottos)).isEqualTo(new BigDecimal("0.35"))
    );
  }

  @Test
  void 수익률을구하고_일치하는갯수를찾는다_자동() {
    // given
    Lottos lottos = new Lottos(
        Arrays.asList(
            makeAutoLotto(1, 2, 3, 4, 5, 6), makeAutoLotto_11_12_13_15_18_19(),
            makeAutoLotto_11_12_13_15_18_19(), makeAutoLotto_11_12_13_15_18_19(),
            makeAutoLotto_11_12_13_15_18_19(), makeAutoLotto_11_12_13_15_18_19(),
            makeAutoLotto_11_12_13_15_18_19(), makeAutoLotto_11_12_13_15_18_19(),
            makeAutoLotto_11_12_13_15_18_19(), makeAutoLotto_11_12_13_15_18_19(),
            makeAutoLotto_11_12_13_15_18_19(), makeAutoLotto_11_12_13_15_18_19(),
            makeAutoLotto_11_12_13_15_18_19(), makeAutoLotto_11_12_13_15_18_19()));

    // when
    WinningNumbers winningNumbers = new WinningNumbers("1, 2, 3, 44, 43, 42");
    MatchesStatus matchesStatus = lottos.findWinner(winningNumbers,
        new BonusBall(winningNumbers, 22));

    // then
    assertAll(
        () -> assertThat(lottos.getAutoLottos()).hasSize(14),
        () -> assertThat(lottos.getManualLottos()).hasSize(0),
        () -> assertThat(matchesStatus.getThreeMatches()).isEqualTo(1), // 5000원
        () -> assertThat(matchesStatus.getFourMatches()).isEqualTo(0), // 50000원
        () -> assertThat(matchesStatus.getFiveMatches()).isEqualTo(0), // 1500000원
        () -> assertThat(matchesStatus.getSixMatches()).isEqualTo(0), // 2000000000원
        () -> assertThat(matchesStatus.findRateOfReturn(lottos)).isEqualTo(new BigDecimal("0.35"))
    );
  }

  @Test
  void 수익률을구하고_일치하는갯수를찾는다2_자동() {
    // given
    Lottos lottos = new Lottos(Arrays.asList(
        makeAutoLotto(1, 2, 3, 4, 5, 6),
        makeAutoLotto(1, 2, 3, 5, 8, 9),
        makeAutoLotto(1, 2, 3, 10, 11, 12),
        makeAutoLotto(1, 2, 15, 16, 11, 12),
        makeAutoLotto(1, 2, 3, 4, 5, 6)
    ));

    // when
    WinningNumbers winningNumbers = new WinningNumbers("1, 2, 3, 4, 5, 6");
    MatchesStatus matchesStatus = lottos.findWinner(winningNumbers,
        new BonusBall(winningNumbers, 22));

    // then
    assertAll(
        () -> assertThat(matchesStatus.getThreeMatches()).isEqualTo(1), // 5000원
        () -> assertThat(matchesStatus.getFourMatches()).isEqualTo(1), // 50000원
        () -> assertThat(matchesStatus.getFiveMatches()).isEqualTo(0), // 1500000원
        () -> assertThat(matchesStatus.getSixMatches()).isEqualTo(2), // 2000000000원
        () -> assertThat(matchesStatus.findRateOfReturn(lottos)).isEqualTo(
            new BigDecimal("800011.00"))
    );
  }

  @Test
  void 수익률을구하고_일치하는갯수를찾는다2_자동_수동() {
    // given
    Lottos lottos = new Lottos(Arrays.asList(
        makeAutoLotto(1, 2, 3, 4, 5, 6),
        makeAutoLotto(1, 2, 3, 5, 8, 9),
        makeAutoLotto(1, 2, 3, 10, 11, 12)
    ));
    lottos.addManualLotto(makeManualLotto(1, 2, 15, 16, 11, 12));
    lottos.addManualLotto(makeManualLotto(1, 2, 3, 4, 5, 6));

    // when
    WinningNumbers winningNumbers = new WinningNumbers("1, 2, 3, 4, 5, 6");
    MatchesStatus matchesStatus = lottos.findWinner(winningNumbers,
        new BonusBall(winningNumbers, 22));

    // then
    assertAll(
        () -> assertThat(matchesStatus.getThreeMatches()).isEqualTo(1), // 5000원
        () -> assertThat(matchesStatus.getFourMatches()).isEqualTo(1), // 50000원
        () -> assertThat(matchesStatus.getFiveMatches()).isEqualTo(0), // 1500000원
        () -> assertThat(matchesStatus.getSixMatches()).isEqualTo(2), // 2000000000원
        () -> assertThat(matchesStatus.findRateOfReturn(lottos)).isEqualTo(
            new BigDecimal("800011.00"))
    );
  }

  @Test
  void 당첨번호를입력하면일치하는갯수를찾는다() {
    AutoLotto lotto = makeAutoLotto(1, 2, 3, 4, 5, 6);

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

  private ManualLotto makeManualLotto_11_12_13_15_18_19() {
    return makeManualLotto(11, 12, 13, 15, 18, 19);
  }

  private ManualLotto makeManualLotto(int value1, int value2, int value3, int value4, int value5, int value6) {
    return new ManualLotto(
        value1 + "," + value2 + "," + value3 + "," + value4 + "," + value5 + "," + value6);
  }

  private AutoLotto makeAutoLotto_11_12_13_15_18_19() {
    return makeAutoLotto(11, 12, 13, 15, 18, 19);
  }

  private AutoLotto makeAutoLotto(int value1, int value2, int value3, int value4, int value5, int value6) {
    return new AutoLotto(makeLotto(Arrays.asList(value1, value2, value3, value4, value5, value6)));
  }

  private Set<LottoNo> makeLotto(List<Integer> inputLotto) {
    Set<LottoNo> lotto = new HashSet<>();
    for (Integer number : inputLotto) {
      lotto.add(LottoNo.of(number));
    }
    return lotto;
  }
}
