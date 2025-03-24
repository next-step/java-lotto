import java.util.List;

public class CalculatorInput {

    private final String input;
    private final List<String> tokens;

    public CalculatorInput(String input) {
        this.input = input;
        this.tokens = List.of(input.split(" "));
    }

    public String getInput() {
        return input;
    }

    public List<String> getTokens() {
        return tokens;
    }
}
