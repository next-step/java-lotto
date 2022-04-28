package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
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

    List<LottoNo> fistLotto = new ArrayList<>();
    fistLotto.add(new LottoNo(8));
    fistLotto.add(new LottoNo(6));
    fistLotto.add(new LottoNo(3));
    fistLotto.add(new LottoNo(4));
    fistLotto.add(new LottoNo(5));
    fistLotto.add(new LottoNo(7));

    List<LottoNo> secondLotto = new ArrayList<>();
    secondLotto.add(new LottoNo(6));
    secondLotto.add(new LottoNo(7));
    secondLotto.add(new LottoNo(8));
    secondLotto.add(new LottoNo(9));
    secondLotto.add(new LottoNo(11));
    secondLotto.add(new LottoNo(30));

    List<LottoNo> winLotto = new ArrayList<>();
    winLotto.add(new LottoNo(8));
    winLotto.add(new LottoNo(7));
    winLotto.add(new LottoNo(6));
    winLotto.add(new LottoNo(21));
    winLotto.add(new LottoNo(45));
    winLotto.add(new LottoNo(29));



    List<Product> allLotto = Arrays.asList(new Product(fistLotto),
        new Product(secondLotto));
    Product winNumbers = new Product(winLotto);
    Statistics statistics = new Statistics();
    assertThat(statistics.result(Grade.THREE, allLotto, winNumbers)).isEqualTo(2);
  }

  @Test
  @DisplayName("승리 수당 테스트")
  void winBenefit() {
    Statistics statistics = new Statistics();
    statistics = statistics.winReward(Grade.THREE,1);
    statistics = statistics.winReward(Grade.FOUR,2);
    statistics = statistics.winReward(Grade.FIVE,1);
    statistics = statistics.winReward(Grade.SIX,1);
    assertThat(statistics).isEqualTo(new Statistics(2001605000L));
  }
}