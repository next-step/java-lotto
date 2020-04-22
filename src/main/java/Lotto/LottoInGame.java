package Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoInGame {

    private final int LOTTO_PRICE = 1000;
    private List<Rank> winners;

    public int translateAmountToQuantity(Amount amount) {
        return amount.getAmount() / LOTTO_PRICE;
    }

    public List<Rank> matchNumber(LottoBundle lottoPapers, PrizeNumbers prizeNumbers) {
        winners = new ArrayList<>();

        for (int i = 0; i < lottoPapers.getSize(); i++) {
            LottoPaper paper = lottoPapers.getLottoPaper(i);
            Rank rank = matchNumberPrize(paper, prizeNumbers);
            winners.add(rank);
        }

        return winners;
    }

    private Rank matchNumberPrize(LottoPaper paper, PrizeNumbers prizeNumbers) {
        int count = 0;
        boolean matchBonus = false;

        count = prizeNumbers.getMatchCount(paper);

        if (count == 5) {
            matchBonus = isBonusWin(paper, prizeNumbers);
        }

        return Rank.valueOf(count, matchBonus);
    }

    public boolean isBonusWin(LottoPaper paper, PrizeNumbers prizeNumbers) {
        return paper.isMatchBonus(prizeNumbers.getBonusNumber());
    }
}
