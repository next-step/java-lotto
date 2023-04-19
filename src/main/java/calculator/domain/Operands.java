package calculator.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Operands {
  private final List<Operand> operands;

  public Operands(List<Operand> operands) {
    this.operands = operands;
  }

  public static Operands of(List<String> operands) {
    List<Operand> operandList = new ArrayList<>();

    for (String operand : operands) {
      operandList.add(new Operand(operand));
    }

    return new Operands(operandList);
  }

  public List<Operand> operands() {
    return Collections.unmodifiableList(operands);
  }
}
