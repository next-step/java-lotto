import java.util.List;

public class StringCalculator {

    private final Splitter splitter;

    public StringCalculator(Splitter splitter) {
        this.splitter = splitter;
    }

    public int calculate(String value) {
        OperationNumbers operationNumbers = splitter.splitOperationNumbers(value);
        List<Operator> operators = splitter.splitOperators(value);

        return operationNumbers.operateByOperations(operators);
    }
}
