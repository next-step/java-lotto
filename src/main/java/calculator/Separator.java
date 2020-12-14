package calculator;

public interface Separator {
    Tokens split(InputText inputText);
    default Token[] getTokens(String[] inputTexts) {
        Token[] values = new Token[inputTexts.length];
        for (int i = 0; i < inputTexts.length; i++) {
            values[i] = new Token(inputTexts[i]);
        }
        return values;
    }
}
