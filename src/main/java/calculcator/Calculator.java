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
        Number result = new Number(Integer.parseInt(tokens[0]));
        for (int i = 1; i < tokens.length; i+=2) {
            Operator operator = OperatorFactory.create(tokens[i]);
            result = result.calculate(operator, Integer.parseInt(tokens[i + 1]));
        }
        return result.getNumber();
    }
}
