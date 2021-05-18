import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SetTest {

  private Set<Integer> numbers;

  @BeforeEach
  void setUp() {
    numbers = new HashSet<>();
    numbers.add(1);
    numbers.add(1);
    numbers.add(2);
    numbers.add(3);
  }

  @Test
  void givenSetExpectedSize_whenGettingSetSize_thenEquals() {
    // Given
    int expectedSetSize = 3;

    // When
    int actualSetSize = numbers.size();

    // Then
    assertEquals(expectedSetSize, actualSetSize);
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3})
  void givenNumbersInSet_whenCheckIfContaining_thenTrue(Integer number) {
    assertTrue(numbers.contains(number));
  }
}
