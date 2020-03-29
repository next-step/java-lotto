package lotto.domain.item;

import enums.LottoPrize;

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

    private boolean isMatchBonus(Item winTicket) {
        int bonus = ((WinLottoTicket) winTicket).getBonus();
        return numbers.contains(bonus);
    }

    public LottoPrize getRank(Item winLottoTicket) {
        int matchCount = getLuckyNumberMatchCount(winLottoTicket);
        boolean matchBonus = isMatchBonus(winLottoTicket);
        return LottoPrize.findRank(matchCount, matchBonus);
    }
}
