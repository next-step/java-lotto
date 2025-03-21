import java.util.ArrayList;
import java.util.List;

public class UserInput {
    private final List<Integer> numbers;
    private final List<Operators> operators;

    private UserInput(List<Integer> numbers, List<Operators> operators) {
        this.numbers = numbers;
        this.operators = operators;
    }

    public static UserInput fromStringInput(String input) {
        validate(input);
        return new UserInput(new ArrayList<>(), new ArrayList<>());
    }

    private static void validate(String input) {
        if (input == null || input.isBlank()) throw new IllegalArgumentException("공백을 입력할 수 없습니다.");
    }
}
