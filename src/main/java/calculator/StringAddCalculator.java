package calculator;

public class StringAddCalculator {

    private final Splitter splitter = new Splitter();

    public int calculate(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        Operands operands = splitter.split(text);

        return operands.sumAll();
    }

}
