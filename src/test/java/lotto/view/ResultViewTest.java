package lotto.view;

import lotto.Lotto;
import lotto.LottoGeneratorTest.TestLottoGenerator;
import lotto.LottoNumber;
import lotto.Lottos;
import lotto.LottoReport;
import lotto.PurchaseAmount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;


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
    String expected = "[1, 45, 2, 44, 3, 43]\n[1, 45, 2, 44, 3, 43]\n";

    ResultView.printLottos(lottos);

    System.setOut(originalOut);
    Assertions.assertEquals(expected, outputStream.toString());
  }

  @DisplayName("당첨 통계를 출력한다.")
  @Test
  void testPrintStatistics() {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;
    System.setOut(new PrintStream(outputStream));

    Lotto winningLotto = new Lotto(List.of(
            new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
            new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)
    ));
    PurchaseAmount purchaseAmount = new PurchaseAmount(3000);
    Lottos lottos = getLottos();

    String expected = "당첨 통계\n" + "---------\n" +
            "3개 일치 (5000원)- 1개\n" +
            "4개 일치 (50000원)- 1개\n" +
            "5개 일치 (1500000원)- 0개\n" +
            "6개 일치 (2000000000원)- 1개\n" +
            "총 수익률은 666685.00입니다.\n";

    ResultView.printStatistics(new LottoReport(purchaseAmount, winningLotto, lottos));

    System.setOut(originalOut);
    Assertions.assertEquals(expected, outputStream.toString());
  }

  private static Lottos getLottos() {
    Lottos lottos = new Lottos(List.of(
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
    return lottos;
  }
}
