package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class SplitterTest {

  @DisplayName("기본 구분자로 나누어진 문자 리스트를 반환한다")
  @Test
  void splitter() {
    assertThat(Splitter.from("1")).containsExactly("1");
    assertThat(Splitter.from("a b")).containsExactly("a", "b");
  }

  @DisplayName("empty 또는 null 문자열은 예외 발생")
  @ParameterizedTest
  @NullAndEmptySource
  void exception(String input) {
    assertThatIllegalArgumentException().isThrownBy(() -> Splitter.from(input))
        .withMessage("나누려는 문자열을 입력하세요");
  }
}