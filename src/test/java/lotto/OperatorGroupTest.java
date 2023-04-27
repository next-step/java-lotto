package lotto;

import lotto.domain.NumberGroup;
import lotto.domain.OperatorGroup;
import lotto.utility.InputChecker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OperatorGroupTest {
  @Test
  @DisplayName("연산자 객체 형성")
  public void createCalculatorNumbersObject() {
    String testInput = " 44 + 55 - 2 / 5 ";

    InputChecker inputChecker = new InputChecker();
    List<String> formulaList = inputChecker.formulaToStrList(testInput);

    OperatorGroup operatorGroup = new OperatorGroup(formulaList);
    List<String> result = operatorGroup.operatorList();

    assertThat(result.size()).isEqualTo(3);
    assertThat(result.get(0)).isEqualTo("+");
    assertThat(result.get(1)).isEqualTo("-");
    assertThat(result.get(2)).isEqualTo("/");
  }

  @Test
  @DisplayName("연산자 객체 형성 시 IllegalArgumentException 발생")
  public void createCalculatorNumbersObject_ThrowIllegalArgumentException() {
    String testInput = " 5 5 5 ";

    InputChecker inputChecker = new InputChecker();
    List<String> formulaList = inputChecker.formulaToStrList(testInput);

    assertThatThrownBy(() -> new OperatorGroup(formulaList))
        .isInstanceOf(IllegalArgumentException.class);
  }
}
