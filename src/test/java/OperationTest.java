import operation.*;
import operation.implemantation.DivideOperation;
import operation.implemantation.MinusOperation;
import operation.implemantation.MultiplyOperation;
import operation.implemantation.PlusOperation;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OperationTest {

    @Test
    @DisplayName("덧셈 계산기")
    void plus() {
        int first = 2;
        int second = 2;
        Operation operation = new PlusOperation();


        int result = operation.calculate(first, second);


        Assertions.assertThat(result).isEqualTo(4);
    }

    @Test
    @DisplayName("뺄셈 계산기")
    void minus() {
        int first = 2;
        int second = 2;
        Operation operation = new MinusOperation();


        int result = operation.calculate(first, second);


        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("곱셈 계산기")
    void multiply() {
        int first = 2;
        int second = 2;
        Operation operation = new MultiplyOperation();


        int result = operation.calculate(first, second);


        Assertions.assertThat(result).isEqualTo(4);
    }

    @Test
    @DisplayName("나눗셈 계산기")
    void divide() {
        int first = 2;
        int second = 2;
        Operation operation = new DivideOperation();


        int result = operation.calculate(first, second);


        Assertions.assertThat(result).isEqualTo(1);
    }

}
