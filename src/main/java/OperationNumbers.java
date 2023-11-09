import java.util.List;

public class OperationNumbers {
    private final List<Integer> value;

    public OperationNumbers(List<Integer> value) {
        this.value = value;
    }

    public int operateByOperations(List<Operator> operators) {
        checkOperators(operators);
        int result = value.get(0);
        for (int idx = 0; idx < operators.size(); idx++) {
            result = operators.get(idx).operate(result, value.get(idx + 1));
        }

        return result;
    }

    private void checkOperators(List<Operator> operators) {
        if (operators.size() != value.size() - 1) {
            throw new IllegalArgumentException("연산자의 수가 일치하지 않습니다.");
        }
    }
}
