package lotto.application;

import lotto.domain.lotto.LottoTicket;
import lotto.domain.lotto.LottoTickets;
import lotto.domain.rank.Rank;
import lotto.domain.rank.RankCalculator;
import lotto.domain.rank.Ranks;
import lotto.domain.shop.Money;
import lotto.domain.shop.Shop;

import java.util.List;
import java.util.stream.Collectors;

public class LottoService {
    public LottoTickets buyLottoTickets(Money money) {
        return Shop.sellLottoTickets(money);
    }

    public Ranks calculateRank(LottoTicket winTicket, LottoTickets lottoTickets) {
        RankCalculator rankCalculator = new RankCalculator(winTicket);
        List<Rank> rankList = lottoTickets.getValues().stream()
                .map(rankCalculator::getRank)
                .collect(Collectors.toList());
        return Ranks.create(rankList);
    }
}
