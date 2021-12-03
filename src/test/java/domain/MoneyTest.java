package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class MoneyTest {

  private Money thousand;
  private Money million;
  private Money trillion;

  @BeforeEach
  void setUp() {
    thousand = new Money(1_000);
    million = new Money(1_000_000);
    trillion = new Money(1_000_000_000);
  }

  @Test
  @DisplayName("음의 정수로 Money객체 생성을 시도할 때 예외가 발생하는지 검증하기 위한 테스트")
  void createMoneyByNegativeInteger() {
    // given
    int negativeInteger = -1_000;
    assertThatThrownBy(() -> {
      // when
      new Money(negativeInteger);
      // then
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName("다른 Money의 value보다 value가 작은지 아닌지에 대한 boolean값을 명확히 반환하는지 검증하기 위한 테스트")
  void isLowerThan() {
    assertAll(() -> {
      assertThat(thousand.isLowerThan(million)).isTrue();
      assertThat(trillion.isLowerThan(million)).isFalse();
    });
  }

  @Test
  @DisplayName("다른 Money의 value로 value를 나눈 몫이 정확하게 반환되는지 검증하기 위한 테스트")
  void quotient() {
    assertAll(() -> {
      assertThat(million.quotient(thousand)).isEqualTo(1_000);
      assertThat(trillion.quotient(thousand)).isEqualTo(1_000_000);
    });
  }

  @Test
  @DisplayName("value를 나누기 위한 분모가 0일 때 예외가 발생하는지 검증하기 위한 테스트")
  void quotientDividedByZero() {
    // given
    Money zero = new Money(0);
    assertThatThrownBy(() -> {
      // when
      million.quotient(zero);
      // then
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName("Money객체와 다른 Money간 뺄셈 결과가 정확하게 반환되는지 검증하기 위한 테스트")
  void subtract() {
    Money millionSubtractThousand = new Money(999_000);
    Money trillionSubstractMillion = new Money(999_000_000);
    assertAll(() -> {
      assertThat(million.subtract(thousand)).isEqualTo(millionSubtractThousand);
      assertThat(trillion.subtract(million)).isEqualTo(trillionSubstractMillion);
    });
  }

  @Test
  @DisplayName("Money객체와 다른 Money간 곱셈 결과가 정확하게 반환되는지 검증하기 위한 테스트")
  void multiply() {
    assertThat(million.multiply(thousand.getValue())).isEqualTo(trillion);
  }

}