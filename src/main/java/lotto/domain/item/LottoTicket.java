package lotto.domain.item;

import enums.LottoPrize;

import java.util.List;

public class LottoTicket extends Lotto {

    public LottoTicket(List<LottoNumber> numbers) {
        super(numbers);
    }

//    public int getLuckyNumberMatchCount(Item winTicket) {
//        int matchCount = 0;
//        for (LottoNumber num : numbers) {
//            matchCount = increaseCountIfMatch(winTicket, matchCount, num);
//        }
//
//        return matchCount;
//    }
//
//    private int increaseCountIfMatch(Item winTicket, int matchCount, LottoNumber winNumber) {
//        for (LottoNumber number : winTicket.getNumbers()) {
//            if (number.equals(winNumber)) {
//                matchCount++;
//            }
//        }
//        return matchCount;
//    }
//
//    private boolean isMatchBonus(Item winTicket) {
//        LottoNumber bonus = ((WinLottoTicket) winTicket).getBonus();
//        return numbers.contains(bonus);
//    }

//    public LottoPrize getRank(Item winLottoTicket) {
//        int matchCount = getLuckyNumberMatchCount(winLottoTicket);
//        boolean matchBonus = isMatchBonus(winLottoTicket);
//        return LottoPrize.findRank(matchCount, matchBonus);
//    }
}
