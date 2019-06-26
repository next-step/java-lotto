package step3.iksoo.lotto2rd;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottoes {
    private List<Lotto> lottoes;

    Lottoes(List<Lotto> lottoes) {
        this.lottoes = lottoes;
    }

    public List<Lotto> getLottoes() {
        return this.lottoes;
    }

    public Map<Rank, Integer> checkLotteryWin(List<Integer> winnerNumbers, int bonusBall) {
        Map<Rank, Integer> matchResult = new HashMap<>();

        Arrays.stream(Rank.values())
                .forEach(rank -> matchResult.put(rank, 0));

        this.lottoes
                .stream()
                .map(lotto -> lotto.checkNumberOfMatches(winnerNumbers, bonusBall))
                .filter(rank -> rank.getCountOfMatch() >= Rank.FIFTH.getCountOfMatch())
                .forEach(rank -> matchResult.put(rank, matchResult.get(rank) + 1));

        return matchResult;
    }
}