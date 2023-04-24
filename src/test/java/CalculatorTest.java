import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("사칙연산 테스트")
public class CalculatorTest {

    @Test
    void 덧셈_연산() {
        String input = "1 + 2";

        String[] strings = input.split(" ");
        int result = 0;
        for (int i = 0; i < strings.length; i++) {
            String s = strings[i];
            if (s.equals("+")) {
                result = addition(strings, i);
            }
        }

        Assertions.assertThat(result).isEqualTo(3);
    }

    @Test
    void 뺄셈_연산() {
        String input = "9 - 3";

        String[] strings = input.split(" ");
        int result = 0;
        for (int i = 0; i < strings.length; i++) {
            String s = strings[i];
            if (s.equals("-")) {
                result = subtraction(strings, i);
            }
        }

        Assertions.assertThat(result).isEqualTo(6);
    }

    @Test
    void 곱하기_연산() {
        String input = "6 * 3";

        String[] strings = input.split(" ");
        int result = 0;
        for (int i = 0; i < strings.length; i++) {
            String s = strings[i];
            if (s.equals("*")) {
                result = multiplication(strings, i);
            }
        }

        Assertions.assertThat(result).isEqualTo(18);
    }

    @Test
    void 나눗셈_연산() {
        String input = "9 / 3";

        String[] strings = input.split(" ");
        int result = 0;
        for (int i = 0; i < strings.length; i++) {
            String s = strings[i];
            if (s.equals("/")) {
                result = division(strings, i);
            }
        }

        Assertions.assertThat(result).isEqualTo(3);
    }

    private int addition (String[]strings, int i){
        return Integer.parseInt(strings[i - 1]) + Integer.parseInt(strings[i + 1]);
    }

    private int subtraction(String[]strings, int i){
        return Integer.parseInt(strings[i - 1]) - Integer.parseInt(strings[i + 1]);
    }

    private int multiplication(String[]strings, int i){
        return Integer.parseInt(strings[i - 1]) * Integer.parseInt(strings[i + 1]);
    }

    private int division(String[]strings, int i){
        return Integer.parseInt(strings[i - 1]) / Integer.parseInt(strings[i + 1]);
    }
}


