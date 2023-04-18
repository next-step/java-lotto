package calculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class OperandsTest {

  private Operands operands;

  @BeforeEach
  public void setUp() {
    operands = Operands.of(List.of("1", "3", "5"));
  }

  @Test
  public void operands_사이즈() {
    Assertions.assertThat(operands.operands())
            .hasSize(3);
  }
}
