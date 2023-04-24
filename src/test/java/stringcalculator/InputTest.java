package stringcalculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputTest {

  @DisplayName("입력값을 split() 메서드를 이용해 문자열을 분리한다.")
  @Test
  public void inputSplit_StringArr_input() {
    Input input = new Input("hi hi hi");

    String[] retInputArr = input.inputSplit();

    assertThat(retInputArr).hasSize(3);
    assertThat("hi").isIn(retInputArr);
  }

}
