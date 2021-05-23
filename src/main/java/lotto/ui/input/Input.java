package lotto.ui.input;

public interface Input {
    Object request(String message);

    void response(String message);
}
