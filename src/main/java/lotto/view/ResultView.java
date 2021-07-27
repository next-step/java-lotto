package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class ResultView {
    
    private int count = 0;
    
    public int correctCheck(Lotto lotto, List<Integer> correctNumbers) {
        for(int i = 0 ; i < correctNumbers.size(); i++) {
            getCorrectCount(lotto, correctNumbers, i);
        }
        return count;
    }

    private void getCorrectCount(Lotto lotto, List<Integer> correctNumbers, int index) {
        if (lotto.getLotto().contains(correctNumbers.get(index))) {
            count++;
        }
    }

}
