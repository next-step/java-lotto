package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OperationsTest {

  @DisplayName("List<String> 타입의 인자로 List<Operation> 타입의 필드를 가진 Operations 객체를 생성한다.")
  @Test
  void create() {
    List<String> splited = List.of("+", "*", "/");
    Operations expectedResult = new Operations(
        List.of(Operation.ADD, Operation.MULTIPLY, Operation.DIVIDE)
    );
    assertThat(Operations.of(splited)).isEqualTo(expectedResult);
  }

  @DisplayName("Operations 객체를 생성할 때, +, -, *, / 가 아닌 값이 들어오면 예외가 발생한다.")
  @Test
  void create_invalid_operator() {
    List<String> splited = List.of(".", "*", "2");
    assertThatThrownBy(() -> Operations.of(splited)).isInstanceOf(IllegalArgumentException.class);
  }
}
