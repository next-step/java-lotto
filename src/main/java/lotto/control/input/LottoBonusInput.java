package lotto.control.input;

import lotto.model.Number;
import lotto.view.View;

public class LottoBonusInput extends InputControl<Number> {
    public LottoBonusInput(View view) {
        super(view);
    }

    @Override
    protected Number input() {
        String input = scanner.nextLine();
        int num = Integer.parseInt(input);
        return new Number(num);
    }
}
