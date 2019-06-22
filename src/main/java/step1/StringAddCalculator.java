package step1;

public class StringAddCalculator {
    private static StringAddCalculator instance = new StringAddCalculator();

    private StringAddCalculator() {}

    public static StringAddCalculator of() {
        return instance;
    }

    public int calculate(String input) {
        if (isEmpty(input)) {
            return 0;
        }

        CalculatorStringTokenizer tokenizer = CalculatorStringTokenizerFactory.createTokenizer(input);

        return Numbers.create(tokenizer.split())
                      .getTotalSum();
    }

    private boolean isEmpty(String input) {
        return input == null || input.isEmpty();
    }

}
