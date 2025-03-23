package calculator;

import calculator.domain.OperationUnit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

class OperationUnitTest {

    @Test
    @DisplayName("미완성된 Operation Unit (연산단위) 으로 계산을 시도하면 IllegalStateException 이 발생한다.")
    public void calculate_with_uncompleted_OperationUnit_throwsIllegalStateException() {
        OperationUnit operationUnit = new OperationUnit();
        operationUnit.add("2");
        operationUnit.add("*");

        assertThatIllegalStateException()
                .isThrownBy(operationUnit::calculate);
    }

    @Test
    @DisplayName("완성된 Operation Unit (연산단위) 에 사용자 입력값을 추가하게 되면 IllegalStateException 이 발생한다.")
    public void add_input_afterCompletion_throwsIllegalStateException() {
        OperationUnit operationUnit = new OperationUnit(10, "/", 2);
        assertThatIllegalStateException()
                .isThrownBy(() -> operationUnit.add("3"));
    }

    @Test
    @DisplayName("완성된 Operation Unit (연산단위) 를 기반으로 정확한 계산 결과를 반환한다.")
    public void calculate_with_completed_OperationUnit() {
        OperationUnit operationUnit = new OperationUnit(10, "/", 2);
        operationUnit.calculate();

        int actual = operationUnit.getResult();
        int expected = 5;

        assertThat(actual).isEqualTo(expected);
    }

}