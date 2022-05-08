package calculator;

import calculator.model.Extractor;
import calculator.model.Number;
import calculator.model.Operator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

public class ExtractorTest {

    @Test
    @DisplayName("숫자, 연산자 추출 테스트")
    void extract_test1(){
        String string = "1";
        List<Number> res = Extractor.extractNumbers(string);
        assertThat(res).containsExactly(new Number("1"));
    }

    @Test
    @DisplayName("숫자, 연산자 추출 테스트")
    void extract_test2(){
        String string = "1+2/3";

        List<Number> nums = Extractor.extractNumbers(string);
        List<Operator> ops = Extractor.extractOperator(string);

        assertThat(nums).containsExactly(
                new Number("1"),new Number("2"), new Number("3"));

        assertThat(ops).containsExactly(Operator.PLUS, Operator.DIVISION);
    }


}
