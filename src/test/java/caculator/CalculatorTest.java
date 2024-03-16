package caculator;

import caculator.type.OperatorType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    private OperationWrapper operationWrapper;

    @BeforeEach
    void setUp() {
        Number initNumber = new Number(5);
        OperationPair plus = new OperationPair(OperatorType.PLUS, new Number(3));
        OperationPair multiple = new OperationPair(OperatorType.MULTIPLE, new Number(3));
        OperationPair divide = new OperationPair(OperatorType.DIVIDE, new Number(2));
        OperationPair minus = new OperationPair(OperatorType.MINUS, new Number(2));

        operationWrapper = new OperationWrapper(initNumber,List.of(plus,multiple,divide,minus));

    }

    @Test
    @DisplayName("입력에 따라 연산을 진행한다 - plus test")
    void plusCalculateTest() {

        Calculator calculator = new Calculator(operationWrapper);

        Number resultNumber = calculator.run();
        Assertions.assertThat(resultNumber).usingRecursiveComparison().isEqualTo(new Number(10));
    }



}
