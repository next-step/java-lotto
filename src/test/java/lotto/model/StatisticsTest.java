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
    List<Lotto> allLotto = Arrays.asList(new Lotto(
            Set.of(new LottoNumber(8),
                new LottoNumber(6),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(7))),
        new Lotto(Set.of(
            new LottoNumber(6),
            new LottoNumber(7),
            new LottoNumber(8),
            new LottoNumber(9),
            new LottoNumber(11),
            new LottoNumber(30))));

    Lotto winNumbers = new Lotto(
        Set.of(
            new LottoNumber(8),
            new LottoNumber(7),
            new LottoNumber(6),
            new LottoNumber(21),
            new LottoNumber(45),
            new LottoNumber(29)
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