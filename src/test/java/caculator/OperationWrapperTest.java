package caculator;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class OperationWrapperTest {

//    @Test
//    void makePairs() {
//        List<String> textArray = List.of("1", "+", "3", "+", "2");
//        OperationWrapper operationWrapper = new OperationWrapper(textArray);
//
//        Operator operator1 = new Operator("+");
//        Operator operator2 = new Operator("+");
//        Number number1 = new Number("3");
//        Number number2 = new Number("2");
//
//        List<OperationPair> operationPairs = List.of(
//                new OperationPair(operator1, number1),
//                new OperationPair(operator2, number2)
//        );
//
//        OperationWrapper expected = new OperationWrapper(new Number(1), operationPairs);
//        Assertions.assertThat(operationWrapper)
//                .usingRecursiveComparison()
//                .isEqualTo(expected);
//    }

//    @Test
//    @DisplayName("연산자 - 숫자 쌍이 맞지 않아도 유효한 리스트까지는 pair가 만들어진다.")
//    void makePairs_edge() {
//        List<String> textArray = List.of("1", "+", "3", "+");
//        OperationWrapper operationWrapper = new OperationWrapper(textArray);
//
//        Operator operator1 = new Operator("+");
//        Number number1 = new Number("3");
//
//        List<OperationPair> operationPairs = List.of(
//                new OperationPair(operator1, number1)
//        );
//
//        OperationWrapper expected = new OperationWrapper(new Number(1), operationPairs);
//        Assertions.assertThat(operationWrapper)
//                .usingRecursiveComparison()
//                .isEqualTo(expected);
//    }
}
