package lotto.view;

import lotto.LottoGeneratorTest.TestLottoGenerator;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoPrize;
import lotto.domain.Lottos;
import lotto.LottoReport;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ResultViewTest {

  @DisplayName("구매한 로또를 출력한다.")
  @Test
  void printLottos() {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;
    System.setOut(new PrintStream(outputStream));

    Lottos lottos = new Lottos(List.of(
            new TestLottoGenerator().generate(),
            new TestLottoGenerator().generate()
    ));
    String expected = "[1, 2, 3, 43, 44, 45]\n[1, 2, 3, 43, 44, 45]\n";

    ResultView.printLottos(lottos);

    System.setOut(originalOut);
    assertEquals(expected, outputStream.toString());
  }

  @DisplayName("당첨 통계를 출력한다.")
  @Test
  void testPrintStatistics() {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;
    System.setOut(new PrintStream(outputStream));

    WinningLotto winningLotto = new WinningLotto(List.of(
            new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
            new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)
    ), new LottoNumber(7));
    PurchaseAmount purchaseAmount = new PurchaseAmount(3000);
    Lottos lottos = getLottos();

    String expected = "당첨 통계\n" + "---------\n" +
            "3개 일치 (5000원)- 1개\n" +
            "4개 일치 (50000원)- 1개\n" +
            "5개 일치 (1500000원)- 0개\n" +
            "5개 일치, 보너스 볼 일치(30000000원)- 1개\n" +
            "6개 일치 (2000000000원)- 1개\n" +
            "총 수익률은 676685.00입니다.\n";

    ResultView.printStatistics(new LottoReport(purchaseAmount, winningLotto, lottos));

    System.setOut(originalOut);
    assertEquals(expected, outputStream.toString());
  }

  @DisplayName("화면 출력 텍스트를 구하는 메서드를 테스트한다.")
  @Test
  void testGetDisplayText() {
    assertEquals("3개 일치 (5000원)- 1개", ResultView.getPrizeAndCountStatus(LottoPrize.THREE_MATCHES, 1));
  }

  private static Lottos getLottos() {
    return new Lottos(List.of(
            new Lotto(List.of(
                    new LottoNumber(1), new LottoNumber(3), new LottoNumber(5),
                    new LottoNumber(7), new LottoNumber(9), new LottoNumber(11))),
            new Lotto(List.of(
                    new LottoNumber(1), new LottoNumber(2), new LottoNumber(5),
                    new LottoNumber(6), new LottoNumber(12), new LottoNumber(14))),
            new Lotto(List.of(
                    new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                    new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))),
            new Lotto(List.of(
                    new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                    new LottoNumber(4), new LottoNumber(5), new LottoNumber(7)))
    ));
  }
}
