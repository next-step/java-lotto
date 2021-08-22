package step1;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NationalNumbersTest {

  private NationalNumbers nationalNumbers;

  @BeforeEach
  void setUp() {
    nationalNumbers = new NationalNumbers(
        Arrays.array("1", "2", "3")
    );
  }

  @DisplayName("문자열 \"1\", \"2\", \"3\"을 가졌을 경우 세수의 합은 6을 반환한다")
  @Test
  void sum() {
    final int actual = nationalNumbers.sum();
    assertThat(actual).isEqualTo(6);
  }
}