package calculator;

import calculator.NumberAdder;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class NumberAdderTest {

  @Test
  void givenPositiveNumbers() {
    // Given
    NumberAdder numberAdder = new NumberAdder();
    String[] numbers = {"1", "2", "3"};

    // When
    int addResult = numberAdder.add(numbers);

    // Then
    assertEquals(6, addResult);
  }

  @Test
  void givenPositiveAndNegativeNumbers() {
    // Given
    NumberAdder numberAdder = new NumberAdder();
    String[] numbers = {"1", "2", "-3"};

    // When
    assertThatThrownBy(() -> numberAdder.add(numbers))
        .isInstanceOf(RuntimeException.class);
  }
}
