package study.stringcalculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValueTest {

  @DisplayName("입력값이 null이거나 빈 공백 문자일 경우 Exception을 던진다.")
  @Test
  public void input_throwsException_nullOrEmptyInput() {
    assertThatThrownBy(() -> new InputValue(null)).isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> new InputValue("")).isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> new InputValue(" ")).isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("split() 메서드를 이용해 문자열을 분리한다.")
  @Test
  public void inputSplit_StringArr() {
    InputValue input = new InputValue("hi hi hi");

    String[] retInputArr = input.split();

    assertThat(retInputArr).hasSize(3);
    assertThat("hi").isIn(retInputArr);
  }

  @DisplayName("split() 메서드를 이용해 분리된 문자열배열 중 공백이 있는 경우 Exception을 던진다.")
  @Test
  public void inputSplit_throwsException_emptyValue() {
    InputValue input = new InputValue("hi  hi  hi");

    assertThatThrownBy(() -> input.split()).isInstanceOf(IllegalArgumentException.class);
  }
}
