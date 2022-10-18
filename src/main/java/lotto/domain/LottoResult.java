package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResult {

    private final Map<Integer, Integer> lottoRankings = new HashMap<>();

    private static final int MINIMUM_RANKING = 3;
    private static final int BONUS_BALL_RANKING = 7;

    private int prizeMoney;
    private String prizePercentage;

    public LottoResult() {
        for (int i = MINIMUM_RANKING; i <= BONUS_BALL_RANKING; i++) {
            lottoRankings.put(i, 0);
        }
    }

    public void calculateLottoResult(List<LottoTicket> lottoTickets, List<Integer> numbers, int paidAmount, int bonusBall) {
        for (LottoTicket lottoTicket : lottoTickets) {
            addEachResult(lottoTicket, numbers, bonusBall);
        }
        calculatePrizePercentage(paidAmount);
    }

    private void addEachResult(LottoTicket lottoTicket, List<Integer> numbers, int bonusBall) {
        int grade = filterMatchingNumbers(lottoTicket, numbers);

        if (grade == 4) {
            checkBonusBallMatch(lottoTicket, bonusBall);
            return;
        }

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

    private void checkBonusBallMatch(LottoTicket lottoTicket, int bonusBall) {
        if (lottoTicket.getNumbers().contains(bonusBall)) {
            lottoRankings.put(BONUS_BALL_RANKING, lottoRankings.get(BONUS_BALL_RANKING) + 1);
            prizeMoney += RankingAward.getAward(BONUS_BALL_RANKING);
        }
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
