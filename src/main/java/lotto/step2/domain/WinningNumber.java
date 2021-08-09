package lotto.step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WinningNumber {
    private List<Integer> winningNumbers;

    public WinningNumber(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public void result(ArrayList<ArrayList> lotto){
        Collections.sort(winningNumbers);
        int lottoTickets = lotto.size();

        for (int i=0; i<lottoTickets; i++) {
            Collections.sort(lotto.get(i));
            int count =0;
            for (int j=0; j<lotto.get(i).size(); j++) {
                if (winningNumbers.get(j)== lotto.get(i).get(j)){
                    count++;
                }
            }


        }
    }
}
