package lotto.control.input;

import lotto.view.View;
import lotto.view.input.DummyView;

import java.util.Scanner;

public abstract class InputControl<T> {
    protected static final Scanner scanner = new Scanner(System.in);
    protected final View view;

    public InputControl() {
        this.view = new DummyView();
    }

    public InputControl(View view) {
        this.view = view;
    }

    public T getValue() {
        view.render();
        return this.input();
    }

    protected abstract T input();
}
