package base;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public final class MethodSourceConstant {
  private static final String CLASS_PATH = "base.MethodSourceConstant";
  public static final String CUSTOM_DELIMITER_ARGUMENTS = CLASS_PATH + "#customDelimiterArguments";
  public static final String NUMBER_STRING_ARGUMENTS = CLASS_PATH + "#numberStringArguments";
  public static final String IS_POSITIVE_NUMBER_STRING_ARGUMENTS = CLASS_PATH + "#isPositiveNumberStringArguments";
  public static final String SUM_ARGUMENTS = CLASS_PATH + "#sumArguments";

  private MethodSourceConstant() {
  }

  static Stream<Arguments> customDelimiterArguments() {
    return Stream.of(
            Arguments.of("//;\n1;2;3", ",|:|;", true)
            , Arguments.of("//*\n1*2*3", ",|:|*", true)
            , Arguments.of("//\n1;2;3", ",|:", false)
            , Arguments.of("1,2,3", ",|:", false)
    );
  }

  static Stream<Arguments> numberStringArguments() {
    return Stream.of(
              Arguments.of(null, "0")
            , Arguments.of("", "0")
            , Arguments.of(" ", "0")
            , Arguments.of("1", "1")
            , Arguments.of("1,2,3", "1,2,3")
            , Arguments.of("//;\n1;2;3", "1;2;3")
            , Arguments.of("//*\n1*2*3", "1*2*3")
    );
  }

  static Stream<Arguments> isPositiveNumberStringArguments() {
    return Stream.of(
            Arguments.of("", true)
            , Arguments.of("123", true)
            , Arguments.of("+123", true)
            , Arguments.of("-123", false)
            , Arguments.of("-123asdf", false)
            , Arguments.of("123asdf", false)
    );
  }

  static Stream<Arguments> sumArguments() {
    return Stream.of(
            Arguments.of("", 0)
            , Arguments.of("  ", 0)
            , Arguments.of(null, 0)
            , Arguments.of("1", 1)
            , Arguments.of("2", 2)
            , Arguments.of("1,2", 3)
            , Arguments.of("1,2,3", 6)
            , Arguments.of("1,2:3", 6)
            , Arguments.of("//;\n1;2;3", 6)
            , Arguments.of("//;\n1,2:3;4", 10)
    );
  }
}
