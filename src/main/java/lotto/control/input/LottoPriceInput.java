package lotto.control.input;

import lotto.view.View;

public class LottoPriceInput extends InputControl<Integer> {

    public LottoPriceInput(View view) {
        this.view = view;
    }

    @Override
    protected Integer input() {
        String input = scanner.nextLine();
        return Integer.parseInt(input);
    }
}
