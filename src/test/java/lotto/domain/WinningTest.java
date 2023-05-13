package lotto.domain;

import static lotto.domain.LottoNumbers.pick;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningTest {

  @Test
  @DisplayName("of에 대해 SECOND를 반환한다")
  void ofReturnSecondTest() {
    assertThat(Winning.of(5, true)).isEqualTo(Winning.SECOND);
  }

  @Test
  @DisplayName("of에 대해 THIRD를 반환한다")
  void ofReturnTHIRDTest() {
    assertThat(Winning.of(5, false)).isEqualTo(Winning.THIRD);
  }
}