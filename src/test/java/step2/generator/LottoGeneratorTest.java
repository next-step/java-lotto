package step2.generator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {
  @Test
  void generateListTest() {
    LottoGenerator generator = new LottoGenerator();
    assertThat(generator.generateList(3).size()).isEqualTo(3);
  }
}
