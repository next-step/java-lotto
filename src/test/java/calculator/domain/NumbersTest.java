package calculator.domain;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumbersTest {

  @DisplayName("List<String> 타입의 인자로 List<Integer> 타입의 필드를 가진 Numbers 객체를 생성한다.")
  @Test
  void create() {
    List<String> splited = List.of("2", "3", "4", "2");
    Numbers expectedResult = new Numbers(List.of(2, 3, 4, 2));
    assertThat(Numbers.of(splited)).isEqualTo(expectedResult);
  }

  @DisplayName("Numbers 객체를 생성할 때, 숫자가 아닌 값이 들어오면 예외가 발생한다.")
  @Test
  void create_not_number() {
    List<String> splited = List.of("+", "+", "/", "2");
    assertThatThrownBy(() -> Numbers.of(splited)).isInstanceOf(IllegalArgumentException.class);
  }
}
