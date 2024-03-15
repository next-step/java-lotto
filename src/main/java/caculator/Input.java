package caculator;

import java.util.List;

public class Input {

    public final List<String> input;

    public Input(final String input) {
        validateInput(input);
        this.input = Util.split(input);
    }

    public boolean isIndexWithinBounds(final int index) {
        return index < input.size();
    }

    public String getByIndex(final int index) {
        return input.get(index);
    }

    private static void validateInput(final String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
    }
}
