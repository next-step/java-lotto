package lotto.ui.input;

public interface Input<R> {
    R request(String message);

    void response(String message);
}
