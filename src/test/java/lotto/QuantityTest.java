package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class QuantityTest {

  @Test
  public void 수량은0보다작을수없다() {
    assertThatThrownBy(() -> {
      new Quantity(-1);
    }).isInstanceOf(RuntimeException.class)
        .hasMessageContaining("수량은 0보다 커야 합니다.");
  }
}
