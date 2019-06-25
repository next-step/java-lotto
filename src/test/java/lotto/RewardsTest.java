package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class RewardsTest {

  @Test
  public void rank별_갯수를_가지고있다() {
    List<Rank> list = new ArrayList<>();
    list.add(Rank.FIFTH);
    list.add(Rank.FIFTH);
    list.add(Rank.SECOND);

    Rewards rewards = new Rewards(list);
    assertThat(rewards.getRankCount(Rank.FIFTH)).isEqualTo(2);
  }

  @Test
  public void 총수익을가지고온다() {
    List<Rank> list = new ArrayList<>();
    list.add(Rank.FIFTH);
    list.add(Rank.FIFTH);
    Rewards rewards = new Rewards(list);
    assertThat(rewards.totalIncome()).isEqualTo(10000);
  }

}