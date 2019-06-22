package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class LottoGeneratorTest {

  @Test
  void generate() {
    int paid = 15000;
    List<Lotto> lottos = LottoGenerator.generate(paid);
    assertThat(lottos.size()).isEqualTo(15);
  }
}
