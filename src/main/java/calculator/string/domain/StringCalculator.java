package calculator.string.domain;

public class StringCalculator implements Calculator {
    private String expression;
    private Delimiter delimiter;

    public StringCalculator() {
        delimiter = new Delimiter();
    }

    @Override
    public void inputExpression(String expression) {
        this.expression = expression;
        if(delimiter.hasNewDelimiter(expression)){
            delimiter.updateDelimiter();
            this.expression = delimiter.extractExpression();
        }
    }

    @Override
    public int calculation() {
        String[] numbers = this.expression.split(delimiter.getDelimiters());
        int result = 0;
        for (String number : numbers) {
            System.out.println(number);
            result += Integer.parseInt(number);
        }

        return result;
    }
}