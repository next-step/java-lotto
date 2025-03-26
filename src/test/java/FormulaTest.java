import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class FormulaTest {

  @Test
  void calculate() {
    Formula formula = new Formula("2 + 3 * 4 - 6 / 2");
    assertThat(formula.calculate()).isEqualTo(7);
  }

  @Test
  void 빈_문자열_입력_시_예외_발생() {
    assertThatThrownBy(() -> new Formula(""))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("식은 빈 값일 수 없습니다.");
  }

  @Test
  void 식은_숫자로_시작해야_한다() {
    assertThatThrownBy(() -> new Formula("+ 2 * 3"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("식의 처음과 마지막은 숫자여야 합니다.");
  }

  @Test
  void 식은_숫자로_끝나야_한다() {
    assertThatThrownBy(() -> new Formula("2 * 3 +"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("식의 처음과 마지막은 숫자여야 합니다.");
  }

  @Test
  void 허용하지_않는_문자_포함_시_예외_발생() {
    assertThatThrownBy(() -> new Formula("2 ^ 3"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("숫자와 사칙연산 기호만 입력할 수 있습니다.");
  }
} 