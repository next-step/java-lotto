package lotto.domain;

import lotto.constant.LottoRanking;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResult {
    private final Map<Integer, Integer> lottoRankings = new HashMap<>();
    private final int MIN_RANKING = 3;
    private final int MAX_RANKING = 6;

    private int award;
    private String winPercentage;

    public LottoResult() {
        for (int i = MIN_RANKING; i <= MAX_RANKING; i++) {
            lottoRankings.put(i, 0);
        }
    }

    public void calculateLottoResult(List<LottoTicket> lottoTickets, LastWeekLottoNumbers lottoNumbers, int price) {
        for (LottoTicket lottoTicket : lottoTickets) {
            lottoMatchingResult(lottoTicket, lottoNumbers);
        }
        calculatePercentage(price);
    }

    private void lottoMatchingResult(LottoTicket lottoTicket, LastWeekLottoNumbers lottoNumbers) {
        int grade = filterMatchingNumbers(lottoTicket, lottoNumbers);
        if (lottoRankings.containsKey(grade)) {
            lottoRankings.put(grade, lottoRankings.get(grade) + 1);
            award += LottoRanking.getAward(grade);
        }
    }

    private int filterMatchingNumbers(LottoTicket lottoTicket, LastWeekLottoNumbers lastWeekLottoNumbers) {
        List<Integer> match = lottoTicket.getNumbers().stream()
                .filter(lastWeekLottoNumbers::contains)
                .collect(Collectors.toList());
        return match.size();
    }

    private void calculatePercentage(int price) {
        double percentage = ((double) award / price);
        this.winPercentage = String.format("%2.02f", percentage);
    }

    public Map<Integer, Integer> getLottoRankings() {
        return this.lottoRankings;
    }

    public String getWinPercentage() {
        return this.winPercentage;
    }
}
