package lotto.domain.item;

import java.util.List;

public class LottoTicket extends Lotto {

    public LottoTicket(List<Integer> numbers) {
        super(numbers);
    }

    public int getLuckyNumberMatchCount(Item winTicket) {
        int match = 0;
        for (Integer num : numbers) {
            match = addCountIfMatch(winTicket, match, num);
        }

        return match;
    }

    private int addCountIfMatch(Item winTicket, int match, Integer num) {
        if (winTicket.getNumbers().contains(num)) {
            match++;
        }
        return match;
    }

    public int getRank(WinLottoTicket winLottoTicket) {
        return getLuckyNumberMatchCount(winLottoTicket);
    }
}
