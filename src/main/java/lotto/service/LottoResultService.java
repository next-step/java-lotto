package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoTickets;
import lotto.domain.Rank;

import java.util.List;
import java.util.stream.Collectors;

public class LottoResultService {

    public List<Rank> rankResult(LottoTickets lottoTickets) {
        return lottoTickets.getLottoList()
                .stream()
                .map(Lotto::getRank)
                .collect(Collectors.toList());
    }

    public Integer yieldResult(LottoTickets lottoTickets) {
        int totalWinningMoney = lottoTickets.getLottoList()
                .stream()
                .mapToInt(l -> l.getRank().getWinningMoney())
                .sum();
        return totalWinningMoney / lottoTickets.getPurchasePrice();
    }

}
