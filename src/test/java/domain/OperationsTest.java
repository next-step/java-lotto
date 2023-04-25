package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OperationsTest {

  @Test
  void 더하기_테스트() {
    Operations operations = new Operations();

    int result = operations.calculate(1, 2, "+");

    assertThat(result).isEqualTo(3);
  }

  @Test
  void 빼기_테스트() {
    Operations operations = new Operations();

    int result = operations.calculate(5, 2, "-");

    assertThat(result).isEqualTo(3);
  }

  @Test
  void 곱하기_테스트() {
    Operations operations = new Operations();

    int result = operations.calculate(2, 3, "*");

    assertThat(result).isEqualTo(6);
  }

  @Test
  void 나누기_테스트() {
    Operations operations = new Operations();

    int result = operations.calculate(6, 2, "/");

    assertThat(result).isEqualTo(3);
  }

  @Test
  void 없는_연산자_테스트() {
    Operations operations = new Operations();
    assertThatIllegalArgumentException()
        .isThrownBy(() -> operations.calculate(1, 2, "%"))
        .withMessageContaining("지원하지 않는 연산자입니다.");
  }
}