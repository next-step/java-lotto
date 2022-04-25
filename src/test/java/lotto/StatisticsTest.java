package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import lotto.enums.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StatisticsTest {

  @Test
  @DisplayName("n개가 일치했는지 확인한다.")
  void coincide() {
    List<Product> allLotto = Arrays.asList(new Product(List.of(1, 2, 3, 4, 5, 6)),
        new Product(List.of(6, 7, 8, 9, 11, 30)));
    List<Integer> winNumbers = Arrays.asList(6, 7, 21, 29, 30, 45);
    assertThat(Rank.THREE.coincideLotto(allLotto, winNumbers)).isEqualTo(1);
  }

  @Test
  @DisplayName("수익률 테스트")
  void yield() {
    Statistics statistics = new Statistics(Rank.THREE);
    assertThat(statistics.yield(5000, 14000)).isEqualTo(0.35);
  }
}