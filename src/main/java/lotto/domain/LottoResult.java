package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResult {

    private final Map<Integer, Integer> lottoRankings = new HashMap<>();

    private static final int MINIMUM_RANKING = 3;
    private static final int FOURTH_RANKING = 4;
    private static final int BONUS_BALL_RANKING = 7;

    private int prizeMoney;
    private String prizePercentage;

    public LottoResult() {
        for (int i = MINIMUM_RANKING; i <= BONUS_BALL_RANKING; i++) {
            lottoRankings.put(i, 0);
        }
    }

    public void calculateLottoResult(List<LottoTicket> lottoTickets, List<Number> numbers, int paidAmount, int bonusBall) {
        LottoDto winningNumbers = new LottoDto(numbers);

        for (LottoTicket lottoTicket : lottoTickets) {
            LottoDto lotto = new LottoDto(lottoTicket.getNumbers());
            checkEachResult(lotto, winningNumbers, bonusBall);
        }
        calculatePrizePercentage(paidAmount);
    }

    private void checkEachResult(LottoDto lotto, LottoDto winningNumbers, int bonusBall) {
        int grade = filterMatchingNumbers(lotto, winningNumbers);

        if (this.lottoRankings.containsKey(grade)) {
            addEachResult(lotto, grade, bonusBall);
        }
    }

    private int filterMatchingNumbers(LottoDto lotto, LottoDto winningNumbers) {
        List<Integer> match = lotto.getLottoNumbers().stream()
                .filter(number -> winningNumbers.getLottoNumbers().contains(number))
                .collect(Collectors.toList());
        return match.size();
    }

    private void addEachResult(LottoDto lotto, int grade, int bonusBall) {
        if (grade == FOURTH_RANKING) {
            grade = checkBonusBallMatch(lotto, bonusBall);
        }
        lottoRankings.put(grade, lottoRankings.get(grade) + 1);
        prizeMoney += RankingAward.getAward(grade);
    }

    private int checkBonusBallMatch(LottoDto lotto, int bonusBall) {
        int grade = FOURTH_RANKING;

        if (lotto.getLottoNumbers().contains(bonusBall)) {
            grade = BONUS_BALL_RANKING;
        }
        return grade;
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
