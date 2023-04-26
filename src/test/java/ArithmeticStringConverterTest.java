import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArithmeticStringConverterTest {
    private final StringConverter<Integer> arithmeticStringConverter = new ArithmeticStringConverter();

    @Test
    void 정수가_아닌_숫자의_문자열인경우_예외를_던진다() {
        String doubleNumb = "1.2";

        Assertions.assertThatExceptionOfType(NumberFormatException.class)
                .isThrownBy(() -> arithmeticStringConverter.convert(doubleNumb));
    }

    @Test
    void 음수인_문자열을_정수로_변환한다() {
        String negativeInteger = "-1";

        Integer res = arithmeticStringConverter.convert(negativeInteger);

        Assertions.assertThat(res).isEqualTo(-1);
    }

//    @Test
//    void 사칙연산자_가_아닌_경우_예외를_던진다() {
//        String nonOperator = "?";
//
//        Assertions.assertThatIllegalArgumentException()
//                .isThrownBy(() -> arithmeticStringConverter.convert(nonOperator));
//    }

    @Test
    void 공백이_존재하는경우_예외를_던진다() {
        String strWithSpace = "12 1";

        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> arithmeticStringConverter.convert(strWithSpace));
    }
}
