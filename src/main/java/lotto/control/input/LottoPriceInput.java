package lotto.control.input;

import lotto.view.View;

public class LottoPriceInput extends InputControl<Integer> {

    public LottoPriceInput(View view) {
        super(view);
    }

    @Override
    protected Integer input() {
        String input = scanner.nextLine();
        return Integer.parseInt(input);
    }
}
