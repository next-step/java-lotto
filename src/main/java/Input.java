import java.util.ArrayList;
import java.util.List;

public class Input {

    private String input;
    private List<String> values;

    public Input(String input) {
        validation(input);
        this.input = input;
        this.values = new ArrayList<>();
    }

    private void validation(String input) {
        if (input == null) {
            throw new IllegalArgumentException("입력 값이 존재하지 않습니다.");
        }

        if (input.isBlank()) {
            throw new IllegalArgumentException("입력 값이 공백 입니다.");
        }
    }
}
