package step2;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class LottoAnalysisTest {

  @Test
  void statIsOne() {
    List<Lotto> lottoes = Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
    Winning winning = new Winning(Arrays.asList(1, 2, 3, 4, 5, 6));

//    LottoStat.calculate(winning, lottoes);
  }
}
