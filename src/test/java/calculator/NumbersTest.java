package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class NumbersTest {

  @DisplayName("더하기")
  @Test
  public void create() {
    Numbers numbers = new Numbers(Arrays.asList("1","2","3"));
    assertThat(numbers.sum()).isEqualTo(6);
  }
}
