package calculator.state;

public interface State {

    State next(String input);

    int value();
}
