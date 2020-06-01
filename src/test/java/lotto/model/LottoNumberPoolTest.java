package lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoNumberPoolTest {

  @Test
  void quickPick() {
    List<Integer> numbers = LottoNumberPool.INSTANCE.quickPick();
    assertThat(numbers.size()).isEqualTo(6);
    assertThat(numbers.stream().distinct().toArray().length).isEqualTo(6);
  }

  @Test
  void quickPick_무작위수확인() {
    for (int i = 0; i < 100; i++) {
      System.out.println(LottoNumberPool.INSTANCE.quickPick());
    }
  }
}