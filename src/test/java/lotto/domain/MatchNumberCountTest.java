package lotto.domain;

import lotto.enums.Rank;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static lotto.enums.Rank.FIFTH;
import static lotto.enums.Rank.FIRST;
import static org.junit.jupiter.api.Assertions.*;

class MatchNumberCountTest {

  @Test
  void revenue() {
    // Given
    MatchNumberCount matchNumberCount = new MatchNumberCount(new HashMap<Rank, Long>() {{
      put(FIFTH, 1L);
    }});

    // When
    Long actualRevenue = matchNumberCount.getRevenue();

    // Then
    assertEquals(5000, actualRevenue);
  }

  @Test
  void name() {
    HashMap<Rank, Long> hashMap = new HashMap<Rank, Long>() {{
      put(FIFTH, 1L);
    }};

    Long aLong = hashMap.get(FIRST);
  }
}