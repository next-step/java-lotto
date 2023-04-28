package lotto.control.input;

import lotto.view.View;
import lotto.view.input.DummyView;

import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

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

    public List<T> getValues(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("The input value must be greater than 0");
        }

        view.render();

        return IntStream.range(0, count)
                .mapToObj(i -> this.input())
                .collect(toList());
    }

    protected abstract T input();
}
