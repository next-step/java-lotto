package calculator.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorsTest {

  private Operators operators;

  @BeforeEach
  public void setUp() {
    operators = Operators.of(List.of("+", "-", "*"));
  }

  @Test
  @DisplayName("처음 + 계산")
  public void next_계산() {
    assertThat(operators.next().applyCalculation(1, 5)).isEqualTo(6);
  }

  @Test
  @DisplayName("Operators 객체 순회하여 계산")
  public void iterate_next_계산() {
    int total = operators.next().applyCalculation(1, 5);
    total = operators.next().applyCalculation(total, 3);
    total = operators.next().applyCalculation(total, 2);

    assertThat(total).isEqualTo(6);
  }
}
