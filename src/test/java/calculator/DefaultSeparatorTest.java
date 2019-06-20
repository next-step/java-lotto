package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class DefaultSeparatorTest {

  @Test
  public void 콤마로_인풋값을_분리한다() {
    String input = "2,3";
    Assertions.assertThat(DefaultSeparator.separate(input)).containsExactly("2", "3");
  }

  @Test
  public void 콤마와_콜론으로_인풋값을_분리한다() {
    String input = "2,3:6:7";
    assertThat(DefaultSeparator.separate(input)).containsExactly("2", "3", "6", "7");
  }


}
