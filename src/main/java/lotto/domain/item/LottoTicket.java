package lotto.domain.item;

import java.util.List;

public class LottoTicket extends Lotto {

    public LottoTicket(List<Integer> numbers) {
        super(numbers);
    }

    public int getLuckyNumberMatchCount(List<Integer> luckyNumber) {
        int match = 0;
        for (Integer num : numbers) {
            match = addCountIfMatch(luckyNumber, match, num);
        }

        return match;
    }

    private int addCountIfMatch(List<Integer> luckyNumber, int match, Integer num) {
        if (luckyNumber.contains(num)) {
            match++;
        }
        return match;
    }
}
