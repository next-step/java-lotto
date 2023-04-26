package lotto.control.input;

import lotto.view.View;
import lotto.view.input.DummyView;

import java.util.Scanner;

public abstract class InputControl<T> {
    protected static final Scanner scanner = new Scanner(System.in);
    protected View view = new DummyView();

    public T getValue() {
        view.render();
        return this.input();
    }

    protected abstract T input();
}
