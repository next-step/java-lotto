package step2;

import org.junit.jupiter.api.Test;
import step2.domain.Number;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {

  @Test
  void constructorTest() {
    List<List<Integer>> userLottoList = Collections.singletonList(Arrays.asList(1, 2, 3, 4, 5, 6));
    LottoGame game = new LottoGame(1000, userLottoList, "1,2,3,4,5,6", "7");
    int i = 1;
    for(Number number : game.getUserLottoList().get(0).getNumbers()) {
      assertThat(number.get()).isEqualTo(i++);
    }
  }

}
