package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class LottoTest {

  @Test
  public void 로또는6개숫자를_갖는다() {
    assertThat(new Lotto().getNumbers().getSize()).isEqualTo(6);
  }

  @Test
  public void 수동입력으로_lotto를_만들수있다_List() {
    List<Integer> autoNumber = makeList("1,2,3,4,5,6");
    assertThat(new Lotto(autoNumber)).isEqualTo(new Lotto(autoNumber));
  }

  @Test
  public void 수동입력으로_lotto를_만들수있다_String() {
    String input = "1,2,3,4,5,6";
    assertThat(new Lotto(input)).isEqualTo(new Lotto(input));
  }

  @Test
  public void 다른로또와_비교하여_동일한숫자의개수를_반환한다() {
    List<Integer> autoNumber = makeList("1,2,3,4,5,6");
    List<Integer> autoNumber2 = makeList("1,2,3,4,5,7");
    assertThat(new Lotto(autoNumber).countSameNumber(new Lotto(autoNumber2))).isEqualTo(5);

  }

  private List<Integer> makeList(String input) {
    List<Integer> result = new ArrayList<>();
    int[] numbers = Arrays.stream(input.split(","))
        .mapToInt(Integer::parseInt).toArray();
    for (int number : numbers) {
      result.add(number);
    }
    return result;

  }

}