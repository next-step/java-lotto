package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LottoTest {

  @Test
  public void 로또는6개숫자를_갖는다() {
    assertThat(new Lotto().getNumbers().getSize()).isEqualTo(6);
  }

}