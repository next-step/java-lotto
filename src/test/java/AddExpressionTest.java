import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AddExpressionTest {

    @DisplayName("덧셈을 합니다.")
    @Test
    void plusCalculate(){
        AddExpression addExpression = new AddExpression(1, 2);
        int result = addExpression.calculate();
        Assertions.assertThat(result).isEqualTo(3);
    }
}
