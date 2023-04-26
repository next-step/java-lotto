package lotto.control.input;

import lotto.view.View;

public class LottoBonusInput extends InputControl<Integer> {
    public LottoBonusInput(View view) {
        super(view);
    }

    @Override
    protected Integer input() {
        String input = scanner.nextLine();
        return Integer.parseInt(input);
    }
}
