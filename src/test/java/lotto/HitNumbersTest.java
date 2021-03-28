package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.HitNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HitNumbersTest {

  @Test
  @DisplayName("[HitNumbers] 당첨 번호 입력 갯수 검증 테스트")
  void validateSizeTest() {
    String inputHit = "1, 2, 3, 4, 5, 6, 7";
    int bonusNumber = 8;

    assertThatThrownBy(() -> new HitNumbers(inputHit, bonusNumber))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName("[HitNumbers] 당첨 번호 중복 검증 테스트")
  void validateDuplicationTest() {
    String inputHit = "1, 2, 3, 4, 5, 5";
    int bonusNumber = 7;

    assertThatThrownBy(() -> new HitNumbers(inputHit, bonusNumber))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName("[HitNumbers] 보너스 번호 중복 검증 테스트")
  void validateBonusTest() {
    String inputHit = "1, 2, 3, 4, 5, 6";
    int bonusNumber = 6;

    assertThatThrownBy(() -> new HitNumbers(inputHit, bonusNumber))
        .isInstanceOf(IllegalArgumentException.class);
  }
}
