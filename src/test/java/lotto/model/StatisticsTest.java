package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import lotto.enums.Grade;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StatisticsTest {

  @Test
  @DisplayName("로또 번호가 맞는지 테스트")
  void awardCount() {
    List<Product> allLotto = Arrays.asList(new Product(
            Set.of(new LottoNo(8),
                new LottoNo(6),
                new LottoNo(3),
                new LottoNo(4),
                new LottoNo(5),
                new LottoNo(7))),
        new Product(Set.of(
            new LottoNo(6),
            new LottoNo(7),
            new LottoNo(8),
            new LottoNo(9),
            new LottoNo(11),
            new LottoNo(30))));

    Product winNumbers = new Product(
        Set.of(
            new LottoNo(8),
            new LottoNo(7),
            new LottoNo(6),
            new LottoNo(21),
            new LottoNo(45),
            new LottoNo(29)
        )
    );
    Statistics statistics = new Statistics();
    assertThat(statistics.result(Grade.FOURTH, allLotto, winNumbers)).isEqualTo(2);
  }

  @Test
  @DisplayName("승리 수당 테스트")
  void winBenefit() {
    Statistics statistics = new Statistics();
    statistics = statistics.winReward(Grade.FOURTH, 1);
    statistics = statistics.winReward(Grade.THIRD, 2);
    statistics = statistics.winReward(Grade.SECOND, 1);
    statistics = statistics.winReward(Grade.FIRST, 1);
    assertThat(statistics).isEqualTo(new Statistics(2001605000L));
  }
}