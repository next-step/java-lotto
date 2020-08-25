package lotto.domain;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Winners {
    private Map<Integer, Integer> winners = new HashMap<>();
    private List<LottoNumber> winningNumbers = new ArrayList<>();

    public Winners(List<LottoNumber> winningNumbers){
        this.winningNumbers = winningNumbers;
    }

    public void addLotto(Lotto lotto){
        int matchedWinningCount = 0;

        for(LottoNumber winningNum : winningNumbers){
            matchedWinningCount = lotto.countWinningNumber(winningNum);
        }

        // key 당첨 일치 갯수, value : 해당하는 lotto 갯수
        winners.put(matchedWinningCount, winners.getOrDefault(matchedWinningCount, 0)+1);
    }

    public int getWinnersCount(int matchedWinningCount){
        return winners.getOrDefault(matchedWinningCount, 0);
    }
}
