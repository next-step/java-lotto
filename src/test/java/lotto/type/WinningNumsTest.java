package lotto.type;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WinningNumsTest {

  @DisplayName("생성자 테스트")
  @Test
  void testConstructor() {
    assertAll(
        () -> assertDoesNotThrow(() -> WinningNums.valueOf("1, 2, 3, 4, 5, 6")),
        () -> assertThrows(RuntimeException.class, () -> WinningNums.valueOf("1, 2, 3, 4, 5"))
    );
  }
}
