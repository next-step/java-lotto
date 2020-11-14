package stringcalculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SplitterTest {

  private Splitter splitter;

  @BeforeEach
  void setUp() {
    this.splitter = new Splitter();
  }

  @ParameterizedTest
  @DisplayName("추가 구분자가 없는 경우의 테스트")
  @CsvSource(value = "a:b:c=a:b:c", delimiter = '=')
  void withoutDelimiterTest(String input, String expected) {
    assertThat(splitter.splitInput(input)).isEqualTo(expected.split(":"));
  }

  // Caution: @CsvSource 를 사용했을 시 \n를 포함하여 1개 스트링으로 만드는 것이 아닌 \n에서 입력 분리 함
  @Test
  @DisplayName("추가 구분자가 존재 할 때의 테스트")
  void withDelimiterTest() {
    assertThat(splitter.splitInput("//;\n1;3;6")).isEqualTo("1;3;6".split(";"));
  }
}
