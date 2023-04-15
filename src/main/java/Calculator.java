public class Calculator {

    private static final String FORMULA_REGEX = "^[0-9+\\-*/\\s]+$\n";

    public static int add(int a, int b) {
        return a+b;
    }

    public static int subtraction(int a, int b) {
        return a-b;
    }

    public static int multiplication(int a, int b) {
        return a*b;
    }

    public static int division(int a, int b) {
        return a/b;
    }

    public static int calculate(String formula) {
        validateFormula(formula);
        return 0;
    }

    private static void validateFormula(String formula){
        if(!formula.matches(FORMULA_REGEX)){
            throw new IllegalArgumentException("숫자와 사칙연산 기호만이 입력 되어야 합니다.");
        }
    }
}
