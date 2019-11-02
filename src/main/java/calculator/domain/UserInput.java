package calculator.domain;

import java.util.Collections;
import java.util.List;

public class UserInput {

    private List<Integer> integers;

    public UserInput(String input) {
        Parser parser = new Parser(input);
        this.integers = parser.getIntegers();
    }

    public List<Integer> getIntegers() {
        return Collections.unmodifiableList(integers);
    }
}
