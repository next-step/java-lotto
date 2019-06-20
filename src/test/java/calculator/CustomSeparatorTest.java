package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CustomSeparatorTest {

  @Test
  public void 커스텀한_구분자로_인풋값을_분리한다() {
    String input ="//;\n1;2;3" ;
    assertThat(CustomSeparator.separate(input)).containsExactly("1","2","3");
  }


}