package lotto;

import lotto.domain.NumberGroup;
import lotto.utility.InputChecker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class NumberGroupTest {
  @Test
  @DisplayName("숫자 객체 형성")
  public void createCalculatorNumbersObject() {
    String testInput = " 44 + 55 - 2 / 5 ";

    InputChecker inputChecker = new InputChecker();
    List<String> formulaList = inputChecker.formulaToStrList(testInput);

    NumberGroup numberGroup = new NumberGroup(formulaList);
    List<String> result = numberGroup.numberList();

    assertThat(result.size()).isEqualTo(4);
    assertThat(result.get(0)).isEqualTo("44");
    assertThat(result.get(1)).isEqualTo("55");
    assertThat(result.get(2)).isEqualTo("2");
    assertThat(result.get(3)).isEqualTo("5");
  }

  @Test
  @DisplayName("숫자 객체 형성 시 IllegalArgumentException 발생")
  public void createCalculatorNumbersObject_ThrowIllegalArgumentException() {
    String testInput = " adfad - 5 ";

    InputChecker inputChecker = new InputChecker();
    List<String> formulaList = inputChecker.formulaToStrList(testInput);

    assertThatThrownBy(() -> new NumberGroup(formulaList))
        .isInstanceOf(IllegalArgumentException.class);
  }
}
