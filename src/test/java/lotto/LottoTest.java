package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class LottoTest {

  @Test
  public void 로또는6개숫자를_갖는다() {
    assertThat(new Lotto().getNumbers().getSize()).isEqualTo(6);
  }

  @Test
  public void 수동으로입력어로_lotto를_만들수있다() {
    List<Integer> autoNumber = new ArrayList<>();
    autoNumber.add(1);
    autoNumber.add(2);
    autoNumber.add(3);
    autoNumber.add(4);
    autoNumber.add(5);
    autoNumber.add(6);
    assertThat(new Lotto(autoNumber)).isEqualTo(new Lotto(autoNumber));
  }

}