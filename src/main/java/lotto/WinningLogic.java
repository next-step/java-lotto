package lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningLogic {

    public List<Integer> makeMatchCounts(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        List matchCounts = new ArrayList();
        Integer winningCount = 0;
        for (int i = 0; i < Lotto.CORRECT_LOTTO_NUMBERS_SIZE; i++) {
            winningCount += countIsSame(lottoNumbers,winningNumbers.get(i));
        }
        matchCounts.add(winningCount);
        matchCounts.add(checkBonusCount(lottoNumbers,winningNumbers.get(Lotto.CORRECT_LOTTO_NUMBERS_SIZE)));

        return matchCounts;
    }

    public Integer checkBonusCount(List<Integer> lottoNumbers, Integer bonusNumber) {
        Integer bonusCount = 0;
        for (int i = 0; i < Lotto.CORRECT_LOTTO_NUMBERS_SIZE; i++) {
            bonusCount += countIsSame(lottoNumbers,bonusNumber);
        }
        return bonusCount;
    }

    public Integer countIsSame(List<Integer> lottoNumbers, Integer winningNumber) {
       if(lottoNumbers.contains(winningNumber)){
           return 1;
       }
       return 0;
    }
}
