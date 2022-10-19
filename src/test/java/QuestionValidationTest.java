import domain.ExpressionValidation;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class QuestionValidationTest {

  @Test
  @DisplayName("null 값 입력시 오류")
  void nullQuestion() {
    Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(
            () -> {
              ExpressionValidation.validateExpression(null);
            }
        );
  }

  @Test
  @DisplayName("공백 값 입력시 오류")
  void emptyQuestion() {
    Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(
            () -> {
              ExpressionValidation.validateExpression(" ");
            }
        );
  }
}
