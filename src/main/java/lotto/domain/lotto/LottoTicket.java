package lotto.domain.lotto;

import enums.Rank;

import java.util.List;

public class LottoTicket extends Lotto {

    public static final double PRICE = 1000;

    public LottoTicket(List<LottoNumber> numbers) {
        super(numbers);
    }

    public LottoTicket(LottoNumbers numbers) {
        super(numbers);
    }

    public int getMatchCount(WinLottoTicket winTicket) {
        int matchCount = 0;
        for (LottoNumber num : this.numbers.getValue()) {
            matchCount = increaseCountIfMatch(winTicket, matchCount, num);
        }

        return matchCount;
    }

    private int increaseCountIfMatch(WinLottoTicket winTicket, int matchCount, LottoNumber winNumber) {
        for (LottoNumber number : winTicket.getNumbers().getValue()) {
            if (number.equals(winNumber)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private boolean isMatchBonus(WinLottoTicket winTicket) {
        LottoNumber bonus = winTicket.getBonus();
        return numbers.getValue().contains(bonus);
    }

    public Rank getRank(WinLottoTicket winLottoTicket) {
        int matchCount = getMatchCount(winLottoTicket);
        boolean matchBonus = isMatchBonus(winLottoTicket);
        return Rank.findRank(matchCount, matchBonus);
    }
}
