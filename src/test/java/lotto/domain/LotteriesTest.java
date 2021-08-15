package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LotteriesTest {

  @DisplayName("로또 콜랙션을 생성하여 리스트로 반환하는 테스트.")
  @Test
  void 일급콜랙션을리스트로반환() {
    List<Lotto> lottos = new ArrayList<>();
    lottos.add(new Lotto(Arrays.asList(1,2,3,4,5,6)));

    Lotteries lotteries = new Lotteries(lottos);

    assertThat(lotteries.toList().size()).isEqualTo(1);
  }
}