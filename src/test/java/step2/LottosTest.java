package step2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class LottosTest {

  @Test
  void count() {
    List<Lotto> lottos = new ArrayList<>();
    lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
    assertThat(new Lottos(lottos).count()).isEqualTo(1);
  }

  @Test
  void concat() {
    Lottos first = new Lottos(Arrays.asList(new Lotto("1,2,3,4,5,6")));
    Lottos second = new Lottos(Arrays.asList(new Lotto("1,2,3,4,5,6")));

    assertThat(Lottos.concat(first, second).count()).isEqualTo(2);
  }

  @Test
  void unmodifiableList() {
    List<Lotto> lottoList = new ArrayList<>();
    lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
    lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));

    Lottos lottos = new Lottos(lottoList);
    // add method 가 없음.
  }
}