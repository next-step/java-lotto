package step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * <pre>
 * * 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
 * * 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
 * * 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.
 * </pre>
 */
public class StringAddCalculatorTest {

    private StringAddCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringAddCalculator();
    }

    @DisplayName("널을 입력받으면 예외가 발생한다.")
    @Test
    void nullInput() {
        assertThatThrownBy(() -> calculator.calculate(null)) //
                .isInstanceOf(IllegalArgumentException.class) //
                .hasMessage("문자열을 입력하시오.");
    }

    @DisplayName("empty string 을 입력하면 0 을 반환한다.")
    @Test
    void emptyString() {
        assertThat(calculator.calculate("")).isEqualTo(0);
    }

    @DisplayName("숫자를 입력하면 그 숫자를 반환한다.")
    @ParameterizedTest
    @CsvSource({"0,0", "1,1", "2,2", "9999,9999"})
    void oneNumber(String stringType, Long longType) {
        assertThat(calculator.calculate(stringType)).isEqualTo(longType);
    }

    @DisplayName("숫자 이외의 값을 입력하면 RuntimeException 을 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"A", "가"})
    void noNumericStrings(String noNumeric) {
        assertThatThrownBy(() -> calculator.calculate(noNumeric)) //
                .isInstanceOf(RuntimeException.class) //
                .hasMessage("숫자로 변환가능한 문자가 아닙니다. : %s", noNumeric);
    }

    @DisplayName("음수를 입력하면 RuntimeException 을 방샐한다.")
    @Test
    void negativeNumericString() {
        assertThatThrownBy(() -> calculator.calculate("-1")) //
                .isInstanceOf(RuntimeException.class) //
                .hasMessage("음수는 처리할 수 없습니다. : -1");
    }

    @DisplayName("콤마와 콜론을 기준으로 더한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2=3", "1:2:3=6"}, delimiter = '=')
    void addWithCommaOrColon(String formula, Long result) {
        assertThat(calculator.calculate(formula)).isEqualTo(result);
    }

    @DisplayName("커스텀 구분자를 입력 받을 수 있다")
    @Test
    void acceptCustomDelimiter() {
        assertThat(calculator.calculate("//;\n1,1")).isEqualTo(2L);
    }

    @DisplayName("커스텀 구분자를 통해 덧셈이 가능하다")
    @Test
    void addWithCustomDelimiter() {
        assertThat(calculator.calculate("//;\n1;1")).isEqualTo(2L);
    }

    private static class StringAddCalculator {

        private final String defaultDelimiterString;

        public StringAddCalculator() {
            this(",:");
        }

        public StringAddCalculator(String defaultDelimiterString) {
            this.defaultDelimiterString = defaultDelimiterString;
        }

        public Long calculate(String formula) {
            if (formula == null) {
                throw new IllegalArgumentException("문자열을 입력하시오.");
            }

            return sum(new FormulaParser(formula).parse());
        }

        private Long sum(String[] numericStrings) {
            Long result = 0L;
            for (String numericString : numericStrings) {
                result += toNumber(numericString);
            }
            return result;
        }

        private Long toNumber(String numericString) {
            if (numericString.isEmpty()) {
                return 0L;
            }

            Long number = toLong(numericString);

            ensurePositiveNumber(number);

            return number;
        }

        private Long toLong(String formula) {
            try {
                return Long.valueOf(formula);
            } catch (NumberFormatException e) {
                throw new RuntimeException(String.format("숫자로 변환가능한 문자가 아닙니다. : %s", formula), e);
            }
        }

        private void ensurePositiveNumber(Long number) {
            if (number < 0L) {
                throw new RuntimeException(String.format("음수는 처리할 수 없습니다. : %d", number));
            }
        }

        private class FormulaParser {
            public static final String CUSTOM_DELIMITER_START = "//";
            public static final String CUSTOM_DELIMITER_END = "\n";
            public static final char REGEX_CHARACTER_SET_START = '[';
            public static final char REGEX_CHARACTER_SET_END = ']';
            private final String formula;

            public FormulaParser(String formula) {
                this.formula = formula;
            }

            public String[] parse() {
                return makeResultFormula().split(makeSplitRegex());
            }

            private String makeResultFormula() {
                if (startWithCustomDelimiterIndicator()) {
                    return subtractCustomDelimiterIndicator();
                }
                return formula;
            }

            private String subtractCustomDelimiterIndicator() {
                return formula.substring(formula.indexOf(CUSTOM_DELIMITER_END) + 1);
            }

            private String makeSplitRegex() {
                StringBuilder delimiterString = new StringBuilder(defaultDelimiterString);
                if (startWithCustomDelimiterIndicator()) {
                    delimiterString.append(extractCustomDelimiter(formula));
                }
                return makeRegexString(delimiterString);
            }

            private String extractCustomDelimiter(String formulaInput) {
                return formulaInput.substring(2, formulaInput.indexOf(CUSTOM_DELIMITER_END));
            }

            private String makeRegexString(StringBuilder delimiterString) {
                return delimiterString.insert(0, REGEX_CHARACTER_SET_START).append(REGEX_CHARACTER_SET_END).toString();
            }

            private boolean startWithCustomDelimiterIndicator() {
                return formula.startsWith(CUSTOM_DELIMITER_START);
            }
        }
    }

}
