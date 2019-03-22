package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;
import org.junit.Test;

public class NumberGeneratorTest {

  @Test
  public void test_generate_sixNumber() {

    // When
    Set<Integer> generateNumber = new NumberGenerator().generate();

    // Then
    assertThat(generateNumber.size()).isEqualTo(6);
  }
}