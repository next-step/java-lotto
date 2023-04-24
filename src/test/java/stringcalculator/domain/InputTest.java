package stringcalculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputTest {

  @DisplayName("입력값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException을 던진다.")
  @Test
  public void input_throwsException_nullOrEmptyInput() {
    assertThatThrownBy(() -> new Input(null)).isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> new Input("")).isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> new Input(" ")).isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("split() 메서드를 이용해 문자열을 분리한다.")
  @Test
  public void inputSplit_StringArr_input() {
    Input input = new Input("hi hi hi");

    String[] retInputArr = input.split();

    assertThat(retInputArr).hasSize(3);
    assertThat("hi").isIn(retInputArr);
  }

}
