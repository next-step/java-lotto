package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static lotto.LottoGeneratorTest.*;

public class ResultViewTest {

  @DisplayName("구매한 로또를 출력한다.")
  @Test
  void printLottos() {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;
    System.setOut(new PrintStream(outputStream));

    List<Lotto> lottos = new ArrayList<>(List.of(
            new TestLottoGenerator().generate(),
            new TestLottoGenerator().generate()
    ));
    String expected = "[1, 45, 2, 44, 3, 43]\n[1, 45, 2, 44, 3, 43]\n";

    ResultView.printLottos(lottos);

    System.setOut(originalOut);
    Assertions.assertEquals(expected, outputStream.toString());
  }

}
