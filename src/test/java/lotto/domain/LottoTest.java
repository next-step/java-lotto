package lotto.domain;

import lotto.input.WinningNumber;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LottoTest {

  @Test
  void matchCount() {
    // Given
    WinningNumber winningNumber = new WinningNumber(new int[]{1, 2, 3, 4, 5, 6});
    Lotto lotto = new Lotto(numberCount -> Arrays.asList(1, 2, 3, 7, 8, 9));

    // When
    int matchCount = lotto.getMatchCountFrom(winningNumber);

    // Then
    assertEquals(3, matchCount);
  }
}