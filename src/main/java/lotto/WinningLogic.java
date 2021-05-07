package lotto;

import java.util.List;

public class WinningLogic {

    public Integer checkWinningCount(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        Integer winningCount = 0;
        for (int i = 0; i < Lotto.CORRECT_LOTTO_NUMBERS_SIZE; i++) {
            winningCount += countIsSame(lottoNumbers,winningNumbers.get(i));
        }
        return winningCount;
    }

    public Integer countIsSame(List<Integer> lottoNumbers, Integer winningNumber) {
       if(lottoNumbers.contains(winningNumber)){
           return 1;
       }
       return 0;
    }
}
