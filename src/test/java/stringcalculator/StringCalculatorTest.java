package stringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringCalculatorTest {
    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        this.stringCalculator = new StringCalculator();
    }

    @Nested
    class plus_메서드는 {

        @Nested
        class null이거나_빈_문자열이_주어질경우 {

            @ParameterizedTest
            @NullAndEmptySource
            void IllegalArgumentException을_던진다(String nullOrEmpty) {
                assertThatIllegalArgumentException()
                        .isThrownBy(() -> stringCalculator.plus(nullOrEmpty));
            }
        }

        @Nested
        class 사칙연산_기호가_아닌_문자열이_주어질경우 {

            @ParameterizedTest
            @ValueSource(strings = {
                    "2 & 3"
            })
            void IllegalArgumentException을_던진다(String not사칙연산_기호_문자열) {
                assertThatIllegalArgumentException()
                        .isThrownBy(() -> stringCalculator.plus(not사칙연산_기호_문자열));
            }
        }

        @Nested
        class 더하기_기호가_포함된_문자열이_주어질경우 {

            @ParameterizedTest
            @CsvSource({
                    "2 + 3,5",
                    "2 + 3 + 4,9"
            })
            void 더한_값을_리턴한다(String expression, int actual) {
                assertThat(stringCalculator.plus(expression))
                        .isEqualTo(actual);
            }
        }
    }
}
