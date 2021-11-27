package lotto.domain.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BudgetTest {

  @ParameterizedTest
  @ValueSource(ints = {-1000, -5000, 0})
  @DisplayName("예산을 생성할 때 0 이하의 정수를 입력할 경우 exception이 반환된다.")
  void create(int input) {
    assertThrows(IllegalArgumentException.class, () -> new Budget(input));
  }

  @ParameterizedTest
  @ValueSource(ints = {100, 200, 500})
  @DisplayName("isEmpty 연산을 통해 예산이 0원임을 확인한다.")
  void emptyTest(int input) {
    Budget budget = new Budget(input);
    budget.minusBudget(input);
    assertTrue(budget.isEmpty());
  }

}