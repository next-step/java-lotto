package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import lotto.domain.HitNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HitNumberTest {

  private HitNumber hitNumber;

  @BeforeEach
  void setUp() {
    hitNumber = new HitNumber();
  }

  @Test
  @DisplayName("[HitNumber] 당첨 번호 입력 갯수 검증 테스트")
  void validateSizeTest() {
    List<String> list = Arrays.asList("1", "2", "3", "4", "5", "6", "7");

    assertThatThrownBy(() -> hitNumber.validateSize(list))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName("[HitNumber] 당첨 번호 중복 검증 테스트")
  void validateDuplicationTest() {
    List<String> list = Arrays.asList("1", "1", "2", "3", "4", "5");

    assertThatThrownBy(() -> hitNumber.validateDuplication(list))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName("[HitNumber] 당첨 각 번호 범위 검증 테스트")
  void validateRangeTest() {
    List<String> list = Arrays.asList("1", "46", "2", "3", "4", "34");

    assertThatThrownBy(() -> hitNumber.validateRange(list))
        .isInstanceOf(IllegalArgumentException.class);
  }
}
