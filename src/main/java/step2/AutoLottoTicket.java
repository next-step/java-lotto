package step2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoLottoTicket extends LottoTicket {
    public AutoLottoTicket() {
        final List<Integer> copy = new ArrayList<>(LOTTO_NUMBERS);
        Collections.shuffle(copy);
        sixNumbers = copy.subList(LOTTO_MIN_INDEX, LOTTO_MAX_INDEX);
        Collections.sort(sixNumbers);
    }

    @Override
    public String toString() {
        return sixNumbers.toString();
    }
}
