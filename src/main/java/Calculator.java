import state.InitialState;
import state.State;

import java.util.List;

public class Calculator {

    private Calculator() {
    }

    public static int calculate(String expression) {
        List<String> tokens = Expression.parse(expression);

        State state = new InitialState();
        for (String token : tokens) {
            state = state.next(token);
        }

        return state.value();
    }

}