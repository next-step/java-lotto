package calculator;

public interface Separator {
    PositiveNumbers split(InputText inputText);
    default PositiveNumber[] getTokens(String[] inputTexts) {
        PositiveNumber[] values = new PositiveNumber[inputTexts.length];
        for (int i = 0; i < inputTexts.length; i++) {
            values[i] = new PositiveNumber(inputTexts[i]);
        }
        return values;
    }
}
