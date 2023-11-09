import java.util.ArrayList;
import java.util.List;

public class OperationNumbers {
    private final List<Integer> value;

    private OperationNumbers(List<Integer> value) {
        this.value = value;
    }

    public static OperationNumbers byString(String value) {
        String[] split = value.split(" ");
        List<Integer> numbers = new ArrayList<>();
        for (int idx = 0; idx < split.length; idx += 2) {
            numbers.add(Integer.parseInt(split[idx]));
        }

        return new OperationNumbers(numbers);
    }

    public int operateByOperations(List<Operator> operators) {
        checkOperators(operators);

        int result = 0;
        for (int idx = 0; idx < operators.size(); idx++) {
            result += operators.get(idx).operate(result, value.get(idx));
        }

        return  result;
    }

    private void checkOperators(List<Operator> operators) {
        if (operators.size() != value.size() - 1) {
            throw new IllegalArgumentException("연산자의 수가 일치하지 않습니다.");
        }
    }
}
