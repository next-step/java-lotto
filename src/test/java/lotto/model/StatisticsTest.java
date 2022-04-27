package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import lotto.enums.Grade;
import lotto.model.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StatisticsTest {

  @Test
  @DisplayName("로또 번호가 맞는지 테스트")
  void awardCount() {
    List<Product> allLotto = Arrays.asList(new Product(List.of(8, 6, 3, 4, 5, 7)),
        new Product(List.of(6, 7, 8, 9, 11, 30)));
    Product winNumbers = new Product(Arrays.asList(8, 7, 6, 21, 45, 29));
    Statistics statistics = new Statistics();
    assertThat(statistics.result(Grade.THREE, allLotto, winNumbers)).isEqualTo(2);
  }

  @Test
  @DisplayName("승리 수당 테스트")
  void win() {
    Statistics statistics = new Statistics();
    statistics = statistics.winReward(Grade.THREE,1);
    statistics = statistics.winReward(Grade.FOUR,2);
    statistics = statistics.winReward(Grade.FIVE,1);
    statistics = statistics.winReward(Grade.SIX,1);
    assertThat(statistics).isEqualTo(new Statistics(2001605000L));
  }
}