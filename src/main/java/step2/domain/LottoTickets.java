package step2.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoTickets {
    private final static int LOTTO_PRICE_PER_PIECE = 1000;
    private final static String LOTTO_RESULT_RANKS = "winningRanks";
    private final static String LOTTO_RESULT_EARNINGS_RATE = "earningsRate";

    private final List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public int countLottoTickets() {
        return lottoTickets.size();
    }

    public List<LottoTicket> getLottoTickets() {
        return new ArrayList<>(lottoTickets);
    }

    public List<WinningRank> checkLottoRank(String lastWinningNumbers) {
        LottoTicket winningTicket = new LottoTicket(lastWinningNumbers);
        return lottoTickets.stream()
                .map(lottoTicket -> lottoTicket.checkWinningRank(winningTicket))
                .filter(winningRank -> winningRank != WinningRank.NOTHING)
                .collect(Collectors.toList());
    }

    public LottoResult confirmWinningResult(String lastWinningNumbers) {
        Map<String, Object> result = new HashMap<>();
        List<WinningRank> winningRanks = checkLottoRank(lastWinningNumbers);
        result.put(LOTTO_RESULT_RANKS, winningRanks);

        long totalPrize = calculateTotalPrize(winningRanks);
        double earningsRate = calculateEarningRate(totalPrize);
        result.put(LOTTO_RESULT_EARNINGS_RATE, earningsRate);
        return new LottoResult(result);
    }

    private long calculateTotalPrize(List<WinningRank> winningRanks) {
        return winningRanks.stream()
                .mapToLong(winningRank -> winningRank.getPrizeMoney())
                .sum();
    }

    private double calculateEarningRate(long totalPrize) {
        return totalPrize / (double) (lottoTickets.size() * LOTTO_PRICE_PER_PIECE);
    }
}