package lotto.control.input;

import lotto.model.Number;
import lotto.view.View;

public class NumberInput extends InputControl<Number> {
    public NumberInput(View view) {
        super(view);
    }

    @Override
    protected Number input() {
        String input = scanner.nextLine();
        int num = Integer.parseInt(input);
        return new Number(num);
    }
}
