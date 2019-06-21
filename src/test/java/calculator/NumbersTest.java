package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class NumbersTest {

  @DisplayName("더하기")
  @Test
  public void sum() {
    Numbers numbers = new Numbers(Arrays.asList("1", "2", "3"));
    assertThat(numbers.sum()).isEqualTo(6);
  }

  @DisplayName("음수 체크")
  @Test
  public void negative() {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> new Numbers(Arrays.asList("-1", "2", "3")));
  }
}
