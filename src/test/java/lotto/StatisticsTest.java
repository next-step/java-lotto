package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StatisticsTest {

  @Test
  @DisplayName("n개가 일치했는지 확인한다.")
  void coincide() {
    Statistics statistics = new Statistics();
    List<List<Integer>> allLotto = Arrays.asList(List.of(1,2,3,4,5,6),List.of(6,7,8,9,11,30));
    List<Integer> winNumbers = Arrays.asList(21,23,27,29,30,45);
    assertThat(statistics.coincideLotto(1, allLotto, winNumbers)).isEqualTo(1);
  }
}