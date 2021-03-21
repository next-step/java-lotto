package calculator.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class FormulaTest {

  @ParameterizedTest
  @ValueSource(strings = {"1:2:3", "1,2,3", "1,2:3", "//;\n1;2;3"})
  @DisplayName("커스텀 구분자와 기본 구분자를 통해서 Operand를 생성할 수 있는가")
  public void createFormulaBySeparator(String userInput) {
    //given
    List<Operand> op = new ArrayList<>();

    Operand operand1 = new Operand("1");
    Operand operand2 = new Operand("2");
    Operand operand3 = new Operand("3");

    op.add(operand1);
    op.add(operand2);
    op.add(operand3);

    //when
    Formula formula = Formula.createFormula(userInput);

    //then
    assertEquals(formula.getOperands(), op);
  }

  @ParameterizedTest
  @ValueSource(strings = {"1:2:3", "1,2,3", "1,2:3", "//;\n1;2;3"})
  @DisplayName("생성된 수식의 결과 값이 제대로 나오는가")
  public void calculateProperly(String userInput) {
    //given
    //when
    Formula formula = Formula.createFormula(userInput);
    //then
    assertEquals(formula.summation(), 6);
  }
}