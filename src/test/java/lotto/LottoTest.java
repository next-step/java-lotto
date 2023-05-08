package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class LottoTest {

  @Test
  void 수익률을구하고_일치하는갯수를찾는다1() {
    Lottos lottos = new Lottos(
        Arrays.asList(
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
            makeLotto1(), makeLotto1(), makeLotto1(), makeLotto1(), makeLotto1(),
            makeLotto1(), makeLotto1(), makeLotto1(), makeLotto1(), makeLotto1(),
            makeLotto1(), makeLotto1(), makeLotto1()));
    WinningNumbers winningNumbers = new WinningNumbers("1, 2, 3, 44, 43, 42");
    MatchesStatus matchesStatus = lottos.findWinner(winningNumbers);
    assertAll(
        () -> assertThat(matchesStatus.getThreeMatches()).isEqualTo(1), // 5000원
        () -> assertThat(matchesStatus.getFourMatches()).isEqualTo(0), // 50000원
        () -> assertThat(matchesStatus.getFiveMatches()).isEqualTo(0), // 1500000원
        () -> assertThat(matchesStatus.getSixMatches()).isEqualTo(0), // 2000000000원
        () -> assertThat(matchesStatus.findRateOfReturn(lottos)).isEqualTo(new BigDecimal("0.35"))
    );
  }

  private Lotto makeLotto1() {
    return new Lotto(Arrays.asList(11, 12, 13, 15, 18, 19));
  }

  @Test
  void 수익률을구하고_일치하는갯수를찾는다2() {
    Lottos lottos = new Lottos(Arrays.asList(
        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
        new Lotto(Arrays.asList(1, 2, 3, 5, 8, 9)),
        new Lotto(Arrays.asList(1, 2, 3, 10, 11, 12)),
        new Lotto(Arrays.asList(1, 2, 15, 16, 11, 12)),
        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))
    ));
    WinningNumbers winningNumbers = new WinningNumbers("1, 2, 3, 4, 5, 6");
    MatchesStatus matchesStatus = lottos.findWinner(winningNumbers);
    assertAll(
        () -> assertThat(matchesStatus.getThreeMatches()).isEqualTo(1), // 5000원
        () -> assertThat(matchesStatus.getFourMatches()).isEqualTo(1), // 50000원
        () -> assertThat(matchesStatus.getFiveMatches()).isEqualTo(0), // 1500000원
        () -> assertThat(matchesStatus.getSixMatches()).isEqualTo(2), // 2000000000원
        () -> assertThat(matchesStatus.findRateOfReturn(lottos)).isEqualTo(new BigDecimal("800011.00"))
    );
  }

  @Test
  void 당첨번호를입력하면일치하는갯수를찾는다() {
    Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

    WinningNumbers winningNumbers = new WinningNumbers("1, 2, 3, 44, 33, 22");
    assertThat(winningNumbers.findHowManyMatches(lotto1)).isEqualTo(3);
  }

  @Test
  void 당첨번호는6개를입력해야한다() {
    assertThatIllegalArgumentException().isThrownBy(() -> {
      new WinningNumbers("1, 2, 3, 4, 5");
    });
  }

  @Test
  void 구입금액에해당하는로또를발급해야한다() {
    List<Lotto> lottos = new Lottos().buy(5000);
    assertThat(lottos).hasSize(5);
  }

  @Test
  void 로또번호는1부터45사이의숫자여야한다_로또는1장당6개의번호를랜덤으로생성한다() {
    LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

    Lotto lottoNumber = new Lotto(lottoNumberGenerator.create());

    assertThat(lottoNumber.getLotto()).hasSize(6);
    assertThat(lottoNumber.getLotto()).allMatch(number -> number < 46 && number > 0);
  }

  @Test
  void 로또구입금액의백원단위는무시하고구매갯수를정한다() {
    List<Lotto> lottos = new Lottos().buy(12300);
    assertThat(lottos).hasSize(12);
  }

  @Test
  void 로또구입금액은1000원이상이어야한다() {
    Lottos lottos = new Lottos();
    assertThatIllegalArgumentException().isThrownBy(() -> {
      lottos.buy(100);
    });
  }

}
