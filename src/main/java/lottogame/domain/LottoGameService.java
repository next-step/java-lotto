package lottogame.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoGameService {
    private Lottos lottos;
    private Integer buyAmount;
    private Map<Rank, Integer> winningResultsByRank = new HashMap<>();


    public LottoGameService(Lottos lottos, Integer buyAmount) {
        this.lottos = lottos;
        this.buyAmount = buyAmount;
    }

    public double calculatePrizeAmount(Lotto winningLotto, LottoNumber bonusNumber) {
        validate(winningLotto, bonusNumber);

        winningResultsByRank = lottos.calculateWinningStatistics(winningLotto, bonusNumber);
        double totalPrizeAmount = lottos.calculateTotalPrizeAmount(winningLotto, bonusNumber);

        return totalPrizeAmount / buyAmount;
    }

    private static void validate(Lotto winningLotto, LottoNumber bonusNumber) {
        if (winningLotto.isMatchingBonus(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public Map<Rank, Integer> getWinningResultsByRank() {
        return winningResultsByRank;
    }
}
