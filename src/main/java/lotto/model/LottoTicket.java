package lotto.model;

import utils.IntegerUtils;
import java.util.Collections;
import java.util.List;

public class LottoTicket {
    private Lotto lotto = new Lotto();

    public int[] getMyNumbers() {
        return myNumbers;
    }

    private int[] myNumbers;
    private int rank = 0;

    public LottoTicket() {
        myNumbers = buyTicket();
    }

    public LottoTicket(int[] numbers) {
        this.myNumbers = numbers;
    }

    public int[] buyTicket() {
        Collections.shuffle(lotto.lottoDrawNumbers);
        int[] numbers = new int[Lotto.LIMIT];

        for(int i = 0; i < Lotto.LIMIT; i++) {
            numbers[i] = lotto.lottoDrawNumbers.get(i);
        }

        return numbers;
    }

    public int announceRank(List<Integer> winningNumbers) {
        for (int i : winningNumbers) {
            isWinner(i);
        }

        return rank;
    }
    
    private void isWinner(int winningNumber) {
        if (IntegerUtils.arrToList(myNumbers).contains(winningNumber)) {
            rank++;
        }
    }
}
