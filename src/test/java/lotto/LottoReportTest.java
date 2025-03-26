package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.domain.PurchaseAmount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoReportTest {

  private Lotto winningLotto;
  private Lottos lottos;

  @BeforeEach
  void setUp() {
    winningLotto = new Lotto(List.of(
            new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
            new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)
    ));

    lottos = new Lottos(List.of(
            new Lotto(List.of(
                    new LottoNumber(1), new LottoNumber(3), new LottoNumber(5),
                    new LottoNumber(7), new LottoNumber(9), new LottoNumber(11))),
            new Lotto(List.of(
                    new LottoNumber(1), new LottoNumber(2), new LottoNumber(5),
                    new LottoNumber(6), new LottoNumber(12), new LottoNumber(14))),
            new Lotto(List.of(
                    new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                    new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)))
    ));
  }

  @Test
  @DisplayName("createCountReport()는 올바른 당첨 개수를 반환해야 한다.")
  void createCountReport_shouldReturnCorrectCountReport() {
    PurchaseAmount purchaseAmount = new PurchaseAmount(3000);
    LottoReport lottoReport = new LottoReport(purchaseAmount, winningLotto, lottos);
    String report = lottoReport.createCountReport();

    assertThat(report).contains("3개 일치 (5000원)- 1개");
    assertThat(report).contains("4개 일치 (50000원)- 1개");
    assertThat(report).contains("6개 일치 (2000000000원)- 1개");
    assertThat(report).contains("5개 일치 (1500000원)- 0개");
  }

  @Test
  @DisplayName("createMoneyReport()는 총 수익률을 정확히 계산해야 한다.")
  void createMoneyReport_shouldCalculateCorrectTotalPrizeRate() {
    PurchaseAmount purchaseAmount = new PurchaseAmount(3000);
    int expectedTotalMoney = (5000 + 50000 + 2000000000);
    double expectedRate = (double) expectedTotalMoney / 3000;

    LottoReport lottoReport = new LottoReport(purchaseAmount, winningLotto, lottos);
    String report = lottoReport.createMoneyReport();

    assertThat(report).isEqualTo(String.format("총 수익률은 %.2f입니다.", expectedRate));
  }
}
