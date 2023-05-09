package calculator;

import calculator.domain.OperatorGroup;
import calculator.domain.InputConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OperatorGroupTest {
  @Test
  @DisplayName("연산자 객체 형성")
  public void createOperatorGroupObject() {
    String testInput = " 44 + 55 - 2 / 5 ";

    InputConverter inputConverter = new InputConverter();
    List<String> formulaList = inputConverter.formulaToStrList(testInput);

    OperatorGroup operatorGroup = new OperatorGroup(formulaList);
    List<String> result = operatorGroup.operatorList();

    assertThat(result.size()).isEqualTo(3);
    assertThat(result.get(0)).isEqualTo("+");
    assertThat(result.get(1)).isEqualTo("-");
    assertThat(result.get(2)).isEqualTo("/");
  }

  @Test
  @DisplayName("연산자 객체 형성 시 IllegalArgumentException 발생")
  public void createOperatorGroupObject_ThrowIllegalArgumentException() {
    String testInput = " 5 5 5 ";

    InputConverter inputConverter = new InputConverter();
    List<String> formulaList = inputConverter.formulaToStrList(testInput);

    assertThatThrownBy(() -> new OperatorGroup(formulaList))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName("연산자 Queue 생성 - remove()로 FIFO 확인")
  public void createOperatorQueue() {
    String testInput = " 5 - 5 + 2";

    InputConverter inputConverter = new InputConverter();
    List<String> formulaList = inputConverter.formulaToStrList(testInput);

    OperatorGroup operatorGroup = new OperatorGroup(formulaList);
    Queue<String > result = operatorGroup.operatorQueue();

    assertThat(result.size()).isEqualTo(2);
    assertThat(result.remove()).isEqualTo("-");
    assertThat(result.remove()).isEqualTo("+");
  }
}
