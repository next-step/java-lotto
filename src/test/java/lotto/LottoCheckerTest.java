package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoChecker;
import lotto.domain.PRIZES;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoCheckerTest {

  private LottoChecker lottoChecker;
  private WinningLotto winningLotto;

  @BeforeEach
  void setUp() {
    lottoChecker = new LottoChecker();
    winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6));
  }

  @Test
  @DisplayName("정상적인 로또 구매 및 당첨 결과 계산 테스트")
  void calculateResults_validCase() {
    List<Lotto> lottos = List.of(
        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
        new Lotto(List.of(1, 2, 3, 10, 11, 12))
    );
    int purchaseAmount = 2000;

    LottoChecker resultChecker = lottoChecker.calculateResults(lottos, winningLotto, purchaseAmount);

    assertThat(resultChecker.findTotalWinningCount(6)).isEqualTo(1);
    assertThat(resultChecker.findTotalWinningCount(3)).isEqualTo(1);
  }

  @Test
  @DisplayName("구입 금액이 음수일 때 예외 발생 테스트")
  void calculateResults_negativePurchaseAmount() {
    List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
    int purchaseAmount = -1000;

    assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> lottoChecker.calculateResults(lottos, winningLotto, purchaseAmount));
  }

  @Test
  @DisplayName("구매한 로또가 없을 때 결과 계산 테스트")
  void calculateResults_emptyLottos() {
    List<Lotto> lottos = List.of();
    int purchaseAmount = 0;

    LottoChecker resultChecker = lottoChecker.calculateResults(lottos, winningLotto, purchaseAmount);

    assertThat(resultChecker.findTotalWinningCount(6)).isEqualTo(0);
    assertThat(resultChecker.findTotalWinningCount(5)).isEqualTo(0);
    assertThat(resultChecker.findTotalWinningCount(4)).isEqualTo(0);
    assertThat(resultChecker.findTotalWinningCount(3)).isEqualTo(0);
    assertThat(resultChecker.getProfitRate()).isEqualTo(0.0);
  }

  @Test
  @DisplayName("모든 로또가 6개 일치하는 경우 테스트")
  void calculateResults_allWinningLottos() {
    List<Lotto> lottos = List.of(
        new Lotto(List.of(1, 2, 3, 4, 5, 6))
    );
    int purchaseAmount = 1000;

    LottoChecker resultChecker = lottoChecker.calculateResults(lottos, winningLotto, purchaseAmount);

    assertThat(resultChecker.findTotalWinningCount(6)).isEqualTo(1);
  }

  @Test
  @DisplayName("총 수익률 계산이 정상적으로 이루어지는지 검증")
  void calculateProfitRate() {
    List<Lotto> lottos = List.of(
        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
        new Lotto(List.of(1, 2, 3, 4, 5, 7))
    );
    int purchaseAmount = 2000;

    LottoChecker resultChecker = lottoChecker.calculateResults(lottos, winningLotto, purchaseAmount);
    double profitRate = resultChecker.getProfitRate();

    long expectedWinning = PRIZES.valueOf(6, winningLotto.isContainBonusBall()).getWinningMoney()
        + PRIZES.valueOf(5, winningLotto.isContainBonusBall()).getWinningMoney();

    assertThat(profitRate).isEqualTo((double) expectedWinning / purchaseAmount);
  }

  @Test
  @DisplayName("보너스 번호 매칭 검증")
  void bonusNumber(){
    int bonusNumber = 7;
    List<Lotto> lottos = List.of(
        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
        new Lotto(List.of(1, 2, 3, 4, 5, 7))
    );

    int purchaseAmount = 2000;
    winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), bonusNumber);
    LottoChecker lottoChecker = this.lottoChecker
        .calculateResults(lottos, winningLotto, purchaseAmount);

    assertThat(lottoChecker.findTotalWinningCount(5)).isEqualTo(1);

  }
}