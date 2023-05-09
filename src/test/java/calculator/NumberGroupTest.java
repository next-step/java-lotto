package calculator;

import calculator.domain.NumberGroup;
import calculator.domain.InputConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class NumberGroupTest {
  @Test
  @DisplayName("숫자 객체 형성")
  public void createNumberGroupObject() {
    String testInput = " 44 + 55 - 2 / 5 ";

    InputConverter inputConverter = new InputConverter();
    List<String> formulaList = inputConverter.formulaToStrList(testInput);

    NumberGroup numberGroup = new NumberGroup(formulaList);
    List<Double> result = numberGroup.numberList();

    assertThat(result.size()).isEqualTo(4);
    assertThat(result.get(0)).isEqualTo(44.0);
    assertThat(result.get(1)).isEqualTo(55.0);
    assertThat(result.get(2)).isEqualTo(2.0);
    assertThat(result.get(3)).isEqualTo(5.0);
  }

  @Test
  @DisplayName("숫자 객체 형성 시 IllegalArgumentException 발생")
  public void createNumberGroupObject_ThrowIllegalArgumentException() {
    String testInput = " adfad - 5 ";

    InputConverter inputConverter = new InputConverter();
    List<String> formulaList = inputConverter.formulaToStrList(testInput);

    assertThatThrownBy(() -> new NumberGroup(formulaList))
        .isInstanceOf(IllegalArgumentException.class);
  }
}
