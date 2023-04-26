package calculcator;

public class Calculator {

    public static final String DELIMITER = " ";

    public static String[] split(String expression) {
        expressionValidation(expression);
        return expression.split(DELIMITER);
    }

    private static void expressionValidation(String expression) {
        if(expression == null){
            throw new IllegalArgumentException("null은 계산할 수 없습니다.");
        }
        if(expression.isBlank()){
            throw new IllegalArgumentException("공백은 계산할 수 없습니다.");
        }
    }

    public static int calculate(String expression) {
        return calculate(split(expression));
    }

    private static Integer calculate(String[] tokens) {
        int result = Integer.parseInt(tokens[0]);
        Operator operator = null;
        for (int i = 1; i < tokens.length; i++) {
            if (isOdd(i)) {
                operator = OperatorFactory.create(tokens[i]);
            }
            if (isEven(i)){
                result = operator.apply(result, Integer.parseInt(tokens[i]));
            }
        }
        return result;
    }

    private static boolean isOdd(int i) {
        return i % 2 == 1;
    }

    private static boolean isEven(int i) {
        return i % 2 == 0;
    }
}
