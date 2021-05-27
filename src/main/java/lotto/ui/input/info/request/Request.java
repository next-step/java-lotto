package lotto.ui.input.info.request;

import lotto.ui.input.GameInput;
import lotto.ui.input.exception.InputException;

public abstract class Request<T> {
    protected final GameInput input;

    public Request(GameInput input) {
        this.input = input;
    }

    protected abstract T request() throws InputException;
}
