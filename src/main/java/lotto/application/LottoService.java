package lotto.application;

import lotto.domain.lotto.LottoGenerator;
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
        return Shop.buyLottoTickets(money);
    }

    public Ranks calculateRank(List<Integer> winTicketNumbers, LottoTickets lottoTickets) {
        RankCalculator rankCalculator = new RankCalculator(LottoGenerator.createManualByIntList(winTicketNumbers));
        List<Rank> rankList = lottoTickets.getValues().stream()
                .map(rankCalculator::getRank)
                .collect(Collectors.toList());
        return Ranks.create(rankList);
    }
}
