package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class LottosTest {

  @Test
  public void 로또들의수량을반환한다() {
    Quantity input = new Quantity(5);
    assertThat(new Lottos(input).getQuantity()).isEqualTo(input);
  }

  @Test
  public void 일치하는숫자가_n개인_로또갯수를_구해온다() {
    List<String> lottoList = new ArrayList<>();
    lottoList.add("1,2,3,4,5,6");
    lottoList.add("7,8,9,10,11,12");
    lottoList.add("13,14,15,16,17,18");

    Lottos lottos = new Lottos(lottoList);
    assertThat(lottos.getSameNumberCount(new Lotto("4,5,6,20,21,22"), 3)).isEqualTo(1);
  }

}