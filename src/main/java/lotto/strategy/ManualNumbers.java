package lotto.strategy;

import java.util.List;

import lotto.tool.TicketGuard;
import lotto.tool.TicketTokenizer;
import lotto.views.Keyboard;

public final class ManualNumbers implements LottoNumbers {

    public ManualNumbers() {
    }

    @Override
    public List<Integer> choose() {
        String text = Keyboard.read();
        List<Integer> numbers = TicketTokenizer.tokenize(text);
        return TicketGuard.guard(numbers);
    }
}
