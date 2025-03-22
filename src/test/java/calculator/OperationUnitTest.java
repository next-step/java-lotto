package calculator;

import calculator.domain.OperationUnit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OperationUnitTest {

    @Test
    @DisplayName("정확한 사용자 입력값을 기반으로 하나의 Operation Unit (연산단위) 를 정상적으로 생성한다.")
    public void generate_operationUnit_basedOn_userInput() {
        int left = 3;
        String operator = "*";
        int right = 7;

        List<String> userInputList = List.of(String.valueOf(left), operator, String.valueOf(right));

        OperationUnit operationUnit = new OperationUnit();
        for (String userInput : userInputList) {
            operationUnit.add(userInput);
        }

        int actualLeft = operationUnit.getLeft();
        String actualOperator = operationUnit.getOperator();
        int actualRight = operationUnit.getRight();

        assertThat(actualLeft).isEqualTo(left);
        assertThat(actualOperator).isEqualTo(operator);
        assertThat(actualRight).isEqualTo(right);
    }

    @Test
    @DisplayName("생성된 Operation Unit (연산단위) 를 기반으로 정확한 계산 결과를 반환한다.")
    public void get_result_basedOn_operationUnit() {
        OperationUnit operationUnit = new OperationUnit(10, "/", 2);
        operationUnit.calculate();

        int actual = operationUnit.getResult();
        int expected = 5;

        assertThat(actual).isEqualTo(expected);
    }

}