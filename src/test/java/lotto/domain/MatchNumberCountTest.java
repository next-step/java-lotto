package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class MatchNumberCountTest {

  @Test
  void revenue() {
    // Given
    MatchNumberCount matchNumberCount = new MatchNumberCount(new HashMap<Integer, Integer>() {{
      put(3, 1);
      put(4, 0);
      put(5, 0);
      put(6, 0);
    }});

    // When
    Integer actualRevenue = matchNumberCount.getRevenue();

    // Then
    assertEquals(5000, actualRevenue);
  }
}