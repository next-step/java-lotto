import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("Enum BasicOperator 테스트")
class BasicOperatorTest {

    @ParameterizedTest(name = "[{index}] 더하기 테스트 {0} + {1}")
    @CsvSource(value = {"1:2:3", "0:1:1"}, delimiter = ':')
    @DisplayName("더하기_테스트")
    public void 더하기_테스트(int x, int y, int result){
        BasicOperator operation = BasicOperator.ADD;
        assertThat(result).isEqualTo(operation.apply(x,y));
    }

    @DisplayName("뺄셈_테스트")
    @ParameterizedTest(name = "[{index}] 뺄셈 테스트 {0} - {1}")
    @CsvSource(value = {"2:1:1", "10:1:9"}, delimiter = ':')
    public void 뺄셈_테스트(int x, int y, int result){
        BasicOperator operation = BasicOperator.SUBTRACT;
        assertThat(result).isEqualTo(operation.apply(x,y));
    }

    @DisplayName("곱하기_테스트")
    @ParameterizedTest(name = "[{index}] 곱하기 테스트 {0} * {1}")
    @CsvSource(value = {"5:2:10", "4:5:20"}, delimiter = ':')
    public void 곱하기_테스트(int x, int y, int result){
        BasicOperator operation = BasicOperator.MUTIPLY;
        assertThat(result).isEqualTo(operation.apply(x,y));
    }

    @DisplayName("나누기_테스트")
    @ParameterizedTest(name = "[{index}] 나누기 테스트 {0} / {1}")
    @CsvSource(value = {"2:1:2", "100:5:20"}, delimiter = ':')
    public void 나누기_테스트(int x, int y, int result){
        BasicOperator operation = BasicOperator.DIVIDE;
        assertThat(result).isEqualTo(operation.apply(x,y));
    }

    @Test
    @DisplayName("나누기_피연산자_0_예외_테스트")
    public void 나누기_예외_테스트(){
        BasicOperator operation = BasicOperator.DIVIDE;
        assertThatIllegalArgumentException().isThrownBy(()->{
            operation.apply(10,0);
        });
    }

    @ParameterizedTest(name = "[{index}] 연산자 {0} 찾기")
    @CsvSource(value = {"+:+", "-:-"}, delimiter = ':')
    @DisplayName("연산자_찾기_테스트")
    public void 연산자_찾기_테스트(String operator, String result){
        BasicOperator operation = BasicOperator.find(operator);

        assertThat(result).isEqualTo(operation.toString());
    }

    @ParameterizedTest(name = "[{index}] 연산자 {0} 예외")
    @ValueSource(strings = {"^","%"})
    @DisplayName("연산자_찾기_예외_테스트")
    public void 연산자_찾기_예외_테스트(String operator){
        assertThatIllegalArgumentException().isThrownBy(()->{
            BasicOperator.find(operator);
        });
    }

    @ParameterizedTest(name = "[{index}] 연산자 {0} 존재유무")
    @CsvSource(value = {"+:true", "^:false"}, delimiter = ':')
    @DisplayName("연산자_찾기_테스트")
    public void 연산자_찾기_테스트(String operator, boolean result){
        assertThat(BasicOperator.hasOperator(operator)).isEqualTo(result);
    }

}