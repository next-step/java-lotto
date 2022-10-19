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

    private long award;
    double percentage;

    public LottoResult() {
        for (int i = MIN_RANKING; i <= MAX_RANKING; i++) {
            lottoRankings.put(i, 0);
        }
    }

    public void calculateLottoResult(List<LottoNumbers> lottoTickets, LottoNumbers lottoNumbers, int price) {
        for (LottoNumbers lottoTicket : lottoTickets) {
            lottoMatchingResult(lottoTicket, lottoNumbers);
        }
        calculatePercentage(price);
    }

    private void lottoMatchingResult(LottoNumbers lottoTicket, LottoNumbers lottoNumbers) {
        int grade = filterMatchingNumbers(lottoTicket, lottoNumbers);
        lottoRankings.computeIfPresent(grade, (key, value) -> {
            award += LottoRanking.getAward(grade);
            return value + 1;
        });

    }

    private int filterMatchingNumbers(LottoNumbers lottoNumbers, LottoNumbers lastWeekLottoNumbers) {
        List<Integer> match = lottoNumbers.getLottoNumbers().stream()
                .filter(lastWeekLottoNumbers::contains)
                .map(LottoNumber::getLottoNumber)
                .collect(Collectors.toList());
        return match.size();
    }

    private void calculatePercentage(int price) {
        this.percentage = ((double) award / price);
    }

    public Map<Integer, Integer> getLottoRankings() {
        return this.lottoRankings;
    }

    public double getPercentage() {
        return this.percentage;
    }
}
