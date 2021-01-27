package calculator.string.domain;

public class StringCalculator implements Calculator {
    private String expression;
    private Delimiter delimiter;

    public StringCalculator() {
        delimiter = new Delimiter();
    }

    @Override
    public void inputExpression(String expression) {
        if (!isUpdateAttributeCalculator(expression)){
            this.expression = expression;
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

    private boolean isUpdateAttributeCalculator(String expression) {
        if(delimiter.isMatch(expression)){
            this.expression = delimiter.getNewExpression();
            delimiter.updateDelimiter();
            return true;
        }
        return false;
    }
}