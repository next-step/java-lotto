package calculator.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Operations {

  private List<Operation> values;

  public Operations(List<Operation> values) {
    this.values = values;
  }

  public static Operations of(List<String> value) {
    List<Operation> operators = value.stream()
        .map(Operation::valueOfOperator)
        .collect(Collectors.toList());
    return new Operations(operators);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Operations that = (Operations) o;
    return Objects.equals(values, that.values);
  }

  @Override
  public int hashCode() {
    return Objects.hash(values);
  }

  public List<Operation> getValues() {
    return values;
  }
}
