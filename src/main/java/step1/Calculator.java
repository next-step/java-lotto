package step1;

public class Calculator {

    private String calculate;
    private int result;

    public Calculator(String input) {
        calculate = input;
    }

    public void deleteSpace() {
        this.calculate = calculate.replace(" ", "");
    }

    public String getString() {
        return this.calculate;
    }

    public int calculateExpression() {
        String[] splited = calculate.split("\\+");
        result = Integer.parseInt(splited[0]) + Integer.parseInt(splited[1]);
        return result;
    }
}
