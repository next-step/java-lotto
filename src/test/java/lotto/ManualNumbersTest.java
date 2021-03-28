package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import lotto.domain.ManualNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ManualNumbersTest {

  @Test
  @DisplayName("[ManualNumbers] 수동 입력 번호 갯수 테스트")
  void manualNumberTest() {
    ManualNumbers purchase = new ManualNumbers(Arrays.asList("1, 2, 3, 4, 5, 6", "1, 2, 3, 4, 5, 6"));

    assertThat(purchase.manualNumbers().size()).isEqualTo(2);
  }
}
