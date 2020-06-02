package study.step2.service;

import study.step2.domain.*;

import java.util.List;
import java.util.stream.Collectors;

public class LottoGameService {

    public List<LottoTicket> purchaseLottos(LottoGame lottoGame){
        return lottoGame.buyLotto(new RandomLottoNumberGenerator());
    }

    public List<Integer> matchWithLastWinningNumbers(List<LottoTicket> tickets, String lastWinningNumbers){
        List<Integer> winningNumbers = new LastWinningNumbers(lastWinningNumbers).getWinningNumbers();
        return tickets.stream()
                      .map(value -> value.countWinningNumbers(winningNumbers))
                      .collect(Collectors.toList());
    }

    public Long totalPrizeMoney(List<Integer> matchingCounts) {
        return  matchingCounts.stream()
                              .mapToLong(matchingNumber -> WinningTable.findRanking(matchingNumber).getPrizeMoney())
                              .sum();
    }
}
