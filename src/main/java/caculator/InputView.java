package caculator;

public class InputView {
    private static final int NULL_EMPTY_VALUE = 0;
    private static final int NORMAL_VALUE = 1;
    private static final String MINUS_OPERATOR = "-";

    private String inputText;

    public InputView() {
    }

    public InputView(String inputText) {
        this.inputText = inputText;
    }

    public int validateInputText(String inputText) {
        if (inputText == null || inputText.isEmpty()) {
            return NULL_EMPTY_VALUE;
        }

        return NORMAL_VALUE;
    }

    public void inputTextIsNegative(String inputText) {
        if (inputText.contains(MINUS_OPERATOR)) {
            throw new RuntimeException("음수가 들어 올 수 없습니다.");
        }

    }
}
