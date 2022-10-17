package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResult {

    private final Map<Integer, Integer> lottoRankings = new HashMap<>();

    private static final int MINIMUM_RANKING = 3;
    private static final int MAXIMUM_RANKING = 6;

    private int prizeMoney;
    private String prizePercentage;

    public LottoResult() {
        for (int i = MINIMUM_RANKING; i <= MAXIMUM_RANKING; i++) {
            lottoRankings.put(i, 0);
        }
    }

    public void calculateLottoResult(List<LottoTicket> lottoTickets, List<Integer> numbers, int paidAmount) {
        for (LottoTicket lottoTicket : lottoTickets) {
            addEachResult(lottoTicket, numbers);
        }
        calculatePrizePercentage(paidAmount);
    }

    private void addEachResult(LottoTicket lottoTicket, List<Integer> numbers) {
        int grade = filterMatchingNumbers(lottoTicket, numbers);

        if (this.lottoRankings.containsKey(grade)) {
            lottoRankings.put(grade, lottoRankings.get(grade) + 1);
            prizeMoney += RankingAward.getAward(grade);
        }
    }

    private int filterMatchingNumbers(LottoTicket lottoTicket, List<Integer> numbers) {
        List<Integer> match = lottoTicket.getNumbers().stream()
                .filter(numbers::contains)
                .collect(Collectors.toList());
        return match.size();
    }

    private void calculatePrizePercentage(int paidAmount) {
        float percentage = ((float) prizeMoney / paidAmount);
        this.prizePercentage = String.format("%2.02f", percentage);
    }

    public Map<Integer, Integer> getLottoRankings() {
        return this.lottoRankings;
    }

    public String getPrizePercentage() {
        return this.prizePercentage;
    }
}
