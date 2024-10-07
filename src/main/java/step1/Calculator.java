package step1;

public class Calculator {

    private String calculate;

    public Calculator(String input) {
        calculate = input;
    }

    public void deleteSpace() {
        this.calculate = calculate.replace(" ", "");
    }

    public String getString() {
        return this.calculate;
    }

}
