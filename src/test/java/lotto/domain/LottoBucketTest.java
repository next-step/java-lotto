package lotto.domain;

import lotto.enums.Rank;
import lotto.input.WinningNumber;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static java.util.Arrays.asList;
import static lotto.enums.Rank.FIFTH;
import static lotto.enums.Rank.FIRST;
import static lotto.enums.Rank.FOURTH;
import static lotto.enums.Rank.MISS;
import static lotto.enums.Rank.SECOND;
import static lotto.enums.Rank.THIRD;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoBucketTest {

  @Test
  void matchNumberCount() {
    // Given
    WinningNumber winningNumber = new WinningNumber(new int[]{1, 2, 3, 4, 5, 6}, 7);

    LottoBucket lottoBucket = new LottoBucket(asList(
        new Lotto(() -> asList(8, 21, 23, 41, 42, 43)),
        new Lotto(() -> asList(3, 5, 11, 16, 32, 38)),
        new Lotto(() -> asList(7, 11, 16, 35, 36, 44)),
        new Lotto(() -> asList(1, 8, 11, 31, 41, 42)),
        new Lotto(() -> asList(13, 14, 16, 38, 42, 45)),
        new Lotto(() -> asList(7, 11, 30, 40, 42, 43)),
        new Lotto(() -> asList(2, 13, 22, 32, 38, 45)),
        new Lotto(() -> asList(23, 25, 33, 36, 39, 41)),
        new Lotto(() -> asList(1, 3, 5, 14, 22, 45)),
        new Lotto(() -> asList(5, 9, 38, 41, 43, 44)),
        new Lotto(() -> asList(2, 8, 9, 18, 19, 21)),
        new Lotto(() -> asList(13, 14, 18, 21, 23, 35)),
        new Lotto(() -> asList(17, 21, 29, 37, 42, 45)),
        new Lotto(() -> asList(3, 8, 27, 30, 35, 44))
    ));

    MatchNumberCount expectedMatchNumberCount = new MatchNumberCount(new HashMap<Rank, Long>() {{
      put(FIRST, 0L);
      put(SECOND, 0L);
      put(THIRD, 0L);
      put(FOURTH, 0L);
      put(FIFTH, 1L);
      put(MISS, 13L);
    }});

    // When
    MatchNumberCount actualMatchNumberCount = lottoBucket.getMatchNumberCountWith(winningNumber);

    // Then
    assertEquals(expectedMatchNumberCount, actualMatchNumberCount);
  }
}