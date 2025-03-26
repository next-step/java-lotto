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
        () -> assertDoesNotThrow(() -> BonusNum.valueOf(4, 45)),
        () -> assertThrows(RuntimeException.class, () -> BonusNum.valueOf(46, 45)),
        () -> assertThrows(RuntimeException.class, () -> BonusNum.valueOf(-1, 45))
    );
  }

  @DisplayName("일치 테스트")
  @Test
  void testIsMatch() {
    assertAll(
        () -> assertThat(BonusNum.valueOf(4, 45).isMatch(4)).isEqualTo(true),
        () -> assertThat(BonusNum.valueOf(4, 45).isMatch(3)).isEqualTo(false)
    );
  }
}
