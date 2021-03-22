package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottosTest {

  private static Lottos lottos = new Lottos();

  @BeforeAll
  static void setup() {
    lottos.assignWinNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
    lottos.add(new Lotto(Arrays.asList(7, 8, 9, 10, 5, 6)));
    lottos.add(new Lotto(Arrays.asList(11, 12, 13, 14, 15, 6)));
    lottos.add(new Lotto(Arrays.asList(10, 2, 3, 4, 5, 6)));
    lottos.add(new Lotto(Arrays.asList(10, 11, 3, 4, 5, 6)));
    lottos.checkResult();
  }

  @ParameterizedTest
  @CsvSource(value = {"FIRST,0", "SECOND,1", "THIRD,1"})
  @DisplayName("입력한 결과의 갯수를 구한다.")
  void getFirstCount(LottoResult result, int expected) {
    //given //when
    int count = lottos.getCount(result);
    //then
    assertEquals(count, expected);
  }

  @Test
  void calculateIncomePercent() {
    double incomePercent = lottos.calculateIncomePercent();
    assertEquals(incomePercent, 387.5);
  }
}