package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class WinningNumbers {
    int[] winNumbers;
    int bonusNumber;
    private Map<Rank, Integer> ranks;

    public WinningNumbers(String[] winNumbers) {
        this(Stream.of(winNumbers).mapToInt(Integer::parseInt).toArray());
    }

    public WinningNumbers(int[] winNumbers) {
        this.winNumbers = winNumbers;
        this.ranks = new HashMap<>();
        for(Rank rank : Rank.values()) {
            this.ranks.put(rank, 0);
        }
    }

    public void choose(List<LottoNumbers> lottoNumbers) {
        for (LottoNumbers lottoNumber : lottoNumbers) {
            count(lottoNumber);
        }
    }

    private void count(LottoNumbers lottoNumber) {
        int correct = 0;
        boolean bonus = false;
        for (int win : winNumbers) {
            correct = lottoNumber.contains(win, correct);
        }
        if (lottoNumber.contains(bonusNumber)) {
            bonus = true;
        }
        Rank rank = Rank.valueOf(correct, bonus);
        this.ranks.put(rank, ranks.getOrDefault(rank, 0) + 1);
    }

    public void bonusNumber(int bonusNumber) {
        this.bonusNumber =  bonusNumber;
    }

    public Map<Rank, Integer> ranks() {
        return ranks;
    }

    public double earningsRate(int price) {
        int total = this.ranks.get(Rank.FIRST) * Rank.FIRST.getWinningMoney()
        + this.ranks.get(Rank.SECOND) * Rank.SECOND.getWinningMoney()
        + this.ranks.get(Rank.THIRD) * Rank.THIRD.getWinningMoney()
        + this.ranks.get(Rank.FOURTH) * Rank.FOURTH.getWinningMoney()
        + this.ranks.get(Rank.FIFTH) * Rank.FIFTH.getWinningMoney();
        return Math.floor((double) total / price * 100.0) / 100.0;
    }
}
