package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ManualNumberTest {

  @Test
  @DisplayName("수동 입력 갯수 생성")
  void createManualNumber() {
    assertThat(new ManualNumber("1")).isEqualTo(new ManualNumber(1));
  }
}