package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class QuantityTest {

  @Test
  public void 수량은0보다작을수없다() {
    assertThatThrownBy(() -> {
      new Quantity(-1);
    }).isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("수량은 0보다 커야 합니다.");
  }

  @Test
  public void 수량에대한_마이너스_기능을_수행한다() {
    assertThat(new Quantity(10).minus(new Quantity(5))).isEqualTo(new Quantity(5));
  }

  @Test
  public void 총량보다_큰값을_빼려고하면_예외발생한다() {
    assertThatThrownBy(()->{
      new Quantity(10).minus(new Quantity(11));
    }).isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("총량 보다 클 수 없습니다.");
  }
}
