package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import lotto.domain.HitNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HitNumbersTest {

  private HitNumbers hitNumbers;

  @BeforeEach
  void setUp() {
    hitNumbers = new HitNumbers();
  }

  @Test
  @DisplayName("[HitNumbers] 당첨 번호 입력 갯수 검증 테스트")
  void validateSizeTest() {
    List<String> list = Arrays.asList("1", "2", "3", "4", "5", "6", "7");

    assertThatThrownBy(() -> hitNumbers.validateSize(list))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName("[HitNumbers] 당첨 번호 중복 검증 테스트")
  void validateDuplicationTest() {
    List<String> list = Arrays.asList("1", "1", "2", "3", "4", "5");

    assertThatThrownBy(() -> hitNumbers.validateDuplication(list))
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
