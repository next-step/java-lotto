package stringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {
    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        this.stringCalculator = new StringCalculator();
    }

    @Nested
    class plus_메서드는 {

        @Nested
        class 더하기_기호가_포함된_문자열이_주어질경우 {

            @ParameterizedTest
            @CsvSource({
                    "2 + 3,5",
            })
            void 더한_값을_리턴한다(String expression, int actual) {
                assertThat(stringCalculator.plus(expression))
                        .isEqualTo(actual);
            }
        }
    }

    @Nested
    class minus_메서드는 {

        @Nested
        class 마이너스_기호가_포함된_문자열이_주어질경우 {

            @ParameterizedTest
            @CsvSource({
                    "2 - 3,-1",
            })
            void 뺀_값을_리턴한다(String expression, int actual) {
                assertThat(stringCalculator.minus(expression))
                        .isEqualTo(actual);
            }
        }
    }

    @Nested
    class multiply_메서드는 {

        @Nested
        class 마이너스_기호가_포함된_문자열이_주어질경우 {

            @ParameterizedTest
            @CsvSource({
                    "2 * 3,6",
            })
            void 곱한_값을_리턴한다(String expression, int actual) {
                assertThat(stringCalculator.multiply(expression))
                        .isEqualTo(actual);
            }
        }
    }

    @Nested
    class division_메서드는 {

        @Nested
        class 마이너스_기호가_포함된_문자열이_주어질경우 {

            @ParameterizedTest
            @CsvSource({
                    "2 / 3,0",
            })
            void 나눈_값을_리턴한다(String expression, int actual) {
                assertThat(stringCalculator.division(expression))
                        .isEqualTo(actual);
            }
        }
    }

}
