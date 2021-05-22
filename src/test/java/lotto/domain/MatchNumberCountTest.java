package lotto.domain;

import lotto.enums.Rank;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static lotto.enums.Rank.FIFTH;
import static lotto.enums.Rank.FIRST;
import static lotto.enums.Rank.FOURTH;
import static lotto.enums.Rank.MISS;
import static lotto.enums.Rank.SECOND;
import static lotto.enums.Rank.THIRD;
import static org.junit.jupiter.api.Assertions.*;

class MatchNumberCountTest {

  @Test
  void revenue() {
    // Given
    MatchNumberCount matchNumberCount = new MatchNumberCount(new HashMap<Rank, Integer>() {{
      put(FIRST, 0);
      put(SECOND, 0);
      put(THIRD, 0);
      put(FOURTH, 0);
      put(FIFTH, 1);
      put(MISS, 0);
    }});

    // When
    Integer actualRevenue = matchNumberCount.getRevenue();

    // Then
    assertEquals(5000, actualRevenue);
  }
}