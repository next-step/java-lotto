package stringaddcalculator;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


public class StringSeparatorTest {

  @ParameterizedTest
  @DisplayName("구분자로 구분된 문자열을 반환한다.")
  @MethodSource("generateString")
  public void separate(List<String> separators, String input, String... expected) {
    StringSeparator stringSeparator = new StringSeparator(separators);
    assertThat(stringSeparator.separateString(input))
        .containsExactlyInAnyOrder(expected);
  }

  public static Stream<Arguments> generateString() {
    return Stream.of(
        Arguments.of(Arrays.asList("^","+"), "AB^C+F^G", new String[]{"AB", "C", "F", "G"}),
        Arguments.of(Arrays.asList(":",","), "AB:C,F:G", new String[]{"AB", "C", "F", "G"}),
        Arguments.of(Arrays.asList(":",",","|"), "AB:C,F|G", new String[]{"AB", "C", "F", "G"})
    );
  }

}
