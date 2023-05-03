package lotto.control.input;

import lotto.view.View;

public class IntegerInput extends InputControl<Integer> {
    public IntegerInput(View view) {
        super(view);
    }

    @Override
    protected Integer input() {
        String input = scanner.nextLine();
        return Integer.valueOf(input);
    }
}
