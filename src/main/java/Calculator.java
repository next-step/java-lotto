import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Calculator {
    private static final String DELIMITER = " ";

    public static int calculate(final String input) {
        validate(input);

        Queue<Integer> operands = new LinkedList<>();
        Queue<Operator> operators = new LinkedList<>();
        parse(input, operands, operators);

        int result = operands.poll();
        while (!operators.isEmpty() && !operands.isEmpty()) {
            result = operators.poll().calculate(result, operands.poll());
        }

        return result;
    }

    private static void validate(final String input) {
        if (Objects.isNull(input) || input.isEmpty()) {
            throw new IllegalArgumentException("값을 입력해주세요");
        }
    }

    private static void parse(final String input, final Queue<Integer> operands, final Queue<Operator> operators) {
        final String[] formula = input.split(DELIMITER);
        for (final String str : formula) {
            if (isNumber(str)) {
                operands.add(Integer.parseInt(str));
                continue;
            }
            operators.add(Operator.getEnum(str));
        }
    }

    private static boolean isNumber(final String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
