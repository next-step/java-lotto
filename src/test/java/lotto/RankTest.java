package lotto;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RankTest {

  private Map<Rank, Integer> sample;

  @BeforeEach
  void setUp() {
    this.sample = new HashMap<>();
    sample.put(Rank.FIRST, 0);
    sample.put(Rank.SECOND, 1);
    // sample.put(Rank.THIRD, 0);
    sample.put(Rank.FOURTH, 0);
    sample.put(Rank.FIFTH, 0);
    sample.put(Rank.MISS, 0);
  }

  @Test
  void testSumExactly() {
    assertThat(Rank.calculateTotalReward(sample, false))
        .isEqualTo(30_000_000);
  }

}
