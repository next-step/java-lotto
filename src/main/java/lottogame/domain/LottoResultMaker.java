package lottogame.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResultMaker {

    private final Map<Rank,Long> winningCountPerRank;
    private final PurchaseAmount purchaseAmount;

    public LottoResultMaker(LottoTicket lottoTicket, WinningInfo winningInfo) {
        winningCountPerRank = getWinningCountPerRank(lottoTicket, winningInfo);
        purchaseAmount = lottoTicket.getPurchaseAmount();
    }

    public Map<Rank, Long> getWinningCountPerRank() {
        return winningCountPerRank;
    }

    public PurchaseAmount getPurchaseAmount() {
        return purchaseAmount;
    }

    Map<Rank, Long> getWinningCountPerRank(LottoTicket lottoTicket, WinningInfo winningInfo) {
        return getGameNumbers(lottoTicket)
                    .stream()
                    .map(gameNumber -> gameNumber.getMatchStatus(winningInfo))
                    .collect(Collectors.groupingBy(Rank::valueOf, Collectors.counting()));
    }

    private List<LottoNumberPackage> getGameNumbers(LottoTicket lottoTicket) {
        return lottoTicket.getGameNumbers();
    }
}
