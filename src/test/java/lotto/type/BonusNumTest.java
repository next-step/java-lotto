package lotto.type;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BonusNumTest {

  @DisplayName("생성자 테스트")
  @Test
  void testConstructor() {
    assertAll(
        () -> assertDoesNotThrow(() -> BonusNum.valueOf(4, WinningNums.valueOf("1, 2, 3, 6, 7, 8"))),
        () -> assertThrows(RuntimeException.class, () -> BonusNum.valueOf(46, WinningNums.valueOf("1, 2, 3, 6, 7, 8"))),
        () -> assertThrows(RuntimeException.class, () -> BonusNum.valueOf(-1, WinningNums.valueOf("1, 2, 3, 6, 7, 8"))),
        () -> assertThrows(RuntimeException.class, () -> BonusNum.valueOf(4, WinningNums.valueOf("1, 2, 3, 4, 5, 6")))
    );
  }

  @DisplayName("일치 테스트")
  @Test
  void testIsMatch() {
    assertAll(
        () -> assertThat(BonusNum.valueOf(4, WinningNums.valueOf("1, 2, 3, 6, 7, 8")).isMatch(4)).isEqualTo(true),
        () -> assertThat(BonusNum.valueOf(4, WinningNums.valueOf("1, 2, 3, 6, 7, 8")).isMatch(3)).isEqualTo(false)
    );
  }
}
