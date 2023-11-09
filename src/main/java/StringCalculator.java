import java.util.List;

public class StringCalculator {

    public static int calculate(String value) {
        OperationNumbers operationNumbers = OperationNumbers.byString(value);
        List<Operator> operators = Operator.byString(value);

        return operationNumbers.operateByOperations(operators);
    }
}
