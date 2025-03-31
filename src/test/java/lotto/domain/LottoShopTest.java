package lotto.domain;

import lotto.domain.generator.LottoGeneratorTest.TestLottoGenerator;
import lotto.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class LottoShopTest {

  @DisplayName("금액을 지불하면 가격에 맞는 로또 티켓들을 생성해주는 기능을 테스트한다.")
  @Test
  void testBuyLottoTicket() {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;
    System.setOut(new PrintStream(outputStream));

    String testInput = "1,2,3,4,5,6\n\n";
    PurchaseInfo purchaseInfo = new PurchaseInfo(10000, 1);
    LottoShop lottoShop = new LottoShop(new TestLottoGenerator(), new InputView(new Scanner(testInput)));

    Lottos lottos = lottoShop.buyLottos(purchaseInfo);

    lottos.printAllLottos();
    System.setOut(originalOut);

    String printedLottos = outputStream.toString().trim();
    assertThat(printedLottos).contains("[1, 2, 3, 4, 5, 6]");
  }
}
