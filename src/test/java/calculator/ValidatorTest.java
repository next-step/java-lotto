package calculator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class ValidatorTest {

  @Test
  public void 음수_및_숫자이외의값이_들어왔을시에_runtimeException() {
    assertThatThrownBy(() -> {
      Validator.validate(new String[]{"1,%,-1"});
    }).isInstanceOf(RuntimeException.class)
        .hasMessageContaining("자연수만 들어올수 있습니다.");
  }

}