package Caculator;

public class Caculator {
    private static final int NULL_EMPTY_VALUE = 0;
    private static final int NORMAL_VALUE = 1;

    private String inputText;

    public Caculator() {
    }

    public Caculator(String inputText) {
        this.inputText = inputText;
    }

    public int validateInputText(String inputText) {
        if (inputText == null || inputText.isEmpty()) {
            return NULL_EMPTY_VALUE;
        }

        return NORMAL_VALUE;
    }

    public int oneNumberInputText(String input) {
        return Integer.parseInt(input);
    }
}
