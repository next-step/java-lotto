package lotto.domain;

import lotto.enums.Rank;
import lotto.input.WinningNumber;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LottoTest {

  @Test
  void rank() {
    // Given
    WinningNumber winningNumber = new WinningNumber(new int[]{1, 2, 3, 4, 5, 6}, 7);
    Lotto lotto = new Lotto(() -> Arrays.asList(1, 2, 3, 7, 8, 9));

    // When
    Rank actualRank = lotto.getRankBy(winningNumber);

    // Then
    assertEquals(Rank.FIFTH, actualRank);
  }
}