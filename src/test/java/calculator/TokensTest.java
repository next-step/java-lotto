package calculator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class TokensTest {

  @Test
  public void 음수_및_숫자이외의값이_들어왔을시에_runtimeException() {
    assertThatThrownBy(() -> {
      new Tokens(new String[]{"1,a,-1"});
    }).isInstanceOf(RuntimeException.class)
        .hasMessageContaining("자연수만 들어올수 있습니다.");
  }

  @Test
  public void 더하기테스트() throws Exception {
    Tokens tokens = new Tokens(new String[]{"1","2"});
    Assertions.assertThat(tokens.sum()).isEqualTo(3);
  }
}
