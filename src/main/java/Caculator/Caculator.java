package Caculator;

public class Caculator {
    private static final int NULL_EMPTY_VALUE = 0;
    private static final int NORMAL_VALUE = 1;
    private static final String SPLIT_TEXT = ",|:";

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

    public int oneNumberInputText(String inputText) {
        return Integer.parseInt(inputText);
    }

    public int splitNumberAndCharater(String inputText) {
        String[] numbers = inputText.split(SPLIT_TEXT);
        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            sum += oneNumberInputText(numbers[i]);
        }

        return sum;
    }
}
