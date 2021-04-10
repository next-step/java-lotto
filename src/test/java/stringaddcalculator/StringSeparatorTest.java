package stringaddcalculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


public class StringSeparatorTest {

  @ParameterizedTest
  @DisplayName("구분자로 구분된 문자열을 반환한다.")
  @MethodSource("generateString")
  public void separate(Set<String> separators, String input, String... expected) {
    StringSeparator stringSeparator = new StringSeparator(separators);
    assertThat(stringSeparator.separateString(input))
        .containsExactlyInAnyOrder(expected);
  }

  public static Stream<Arguments> generateString() {
    return Stream.of(
        Arguments.of(generateSet("^", "+"), "AB^C+F^G", new String[]{"AB", "C", "F", "G"}),
        Arguments.of(generateSet(":", ","), "AB:C,F:G", new String[]{"AB", "C", "F", "G"}),
        Arguments.of(generateSet(":", ",", "|"), "AB:C,F|G", new String[]{"AB", "C", "F", "G"})
    );
  }

  private static Set<String> generateSet(String... val) {
    return new HashSet<>(Arrays.asList(val));
  }

}
