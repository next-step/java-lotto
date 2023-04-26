import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    public void readExpression(String exp) throws IllegalArgumentException {

        validExpression(exp);
        List<Integer> numbers = extractNumbers(exp.split(" "));
        List<Operation> operations = extractOperation(exp.split(" "));
    }

    private void validExpression(String exp) {
        if (exp == null || exp.isBlank()) {
            throw new IllegalArgumentException("유효한 표현식이 아닙니다.");
        }
    }


    List<Integer> extractNumbers(String[] splits) {
        List<Integer> stringNums = new ArrayList<>();

        for (int i = 0; i < splits.length; i++) {
            if (i % 2 != 0) {
                continue;
            }
            stringNums.add(toInt(splits[i]));
        }
        return stringNums;
    }

    private Integer toInt(String stringNum) {
        Integer num = null;
        try {
            num = Integer.parseInt(stringNum);
        } catch (NullPointerException | NumberFormatException e) {
            throw new IllegalArgumentException("올바른 정수 값이 아닙니다.");
        }
        return num;
    }

    List<Operation> extractOperation(String[] splits) {
        List<Operation> operation = new ArrayList<>();

        for (int i = 0; i < splits.length; i++) {
            if (i % 2 == 0) {
                continue;
            }
            operation.add(Operation.toOperation(splits[i]));
        }
        return operation;

    }

}

