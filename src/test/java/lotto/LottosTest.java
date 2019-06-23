package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LottosTest {

  @Test
  public void 로또들의수량을반환한다() {
    Quantity input = new Quantity(5);
    assertThat(new Lottos(input).getQuantity()).isEqualTo(input);

  }

}