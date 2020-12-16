package step2.generator;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {
  @Test
  void generateListTest() {
    assertThat(LottoGenerator.randomGenerateList(3).size()).isEqualTo(3);
  }

  @Test
  void getLottoNumberListFromStringTest() {
    String input = "1,2,3,4,5,6";
    List<Integer> results = LottoGenerator.getLottoNumberListFromString(input);
    assertThat(results.size()).isEqualTo(6);
    for (int i = 0; i < 6; i++) {
      assertThat(results.get(i)).isEqualTo(i + 1);
    }
  }
}
