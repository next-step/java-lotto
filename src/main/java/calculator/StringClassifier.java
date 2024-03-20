package calculator;

public class StringClassifier {
    public static boolean isNumber(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    public static boolean isOperator(String str) {
        return str.matches("[+\\-*/]");
    }
}
