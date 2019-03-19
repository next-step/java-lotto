package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.Test;

public class NumberGeneratorTest {

  @Test
  public void test_generate_sixNumber() {

    // When
    List<Number> generateNumber = new NumberGenerator().generate();

    // Then
    assertThat(generateNumber.size()).isEqualTo(6);
  }
}