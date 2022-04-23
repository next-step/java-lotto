package calculator.domain;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumbersTest {

  @DisplayName("split된 문자열을 입력받으면, 숫자만 갖는 리스트를 가진 Numbers 객체를 생성한다.")
  @Test
  void create() {
    List<String> splited = List.of("2", "+", "3", "*", "4", "/", "2");
    Numbers expectedResult = new Numbers(List.of(2, 3, 4, 2));
    assertThat(Numbers.of(splited)).isEqualTo(expectedResult);
  }
}
