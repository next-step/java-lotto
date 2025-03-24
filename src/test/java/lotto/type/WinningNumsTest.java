package lotto.type;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WinningNumsTest {

  @DisplayName("생성자 테스트")
  @Test
  void testConstructor() {
    assertAll(
        () -> assertDoesNotThrow(() -> new WinningNums("1, 2, 3, 4, 5, 6")),
        () -> assertThrows(RuntimeException.class, () -> new WinningNums("1, 2, 3, 4, 5"))
    );
  }
}
