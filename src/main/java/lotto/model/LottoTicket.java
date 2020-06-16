package lotto.model;

import utils.IntegerUtils;
import java.util.Collections;

public class LottoTicket {
    private int[] myNumbers;
    private int rank = 0;
    private Rank rankType;

    private Lotto lotto = new Lotto();

    public LottoTicket() {
        myNumbers = buyTicket();
    }

    public LottoTicket(int[] numbers) {
        this.myNumbers = numbers;
    }

    public int[] getMyNumbers() {
        return myNumbers;
    }

    public int[] buyTicket() {
        Collections.shuffle(lotto.lottoDrawNumbers);
        int[] numbers = new int[Lotto.LIMIT];

        for(int i = 0; i < Lotto.LIMIT; i++) {
            numbers[i] = lotto.lottoDrawNumbers.get(i);
        }

        return numbers;
    }

    public Rank announceRank(int[] winningNumbers) {
        for (int i : winningNumbers) {
            isWinner(i);
        }

        setRank(rank);
        return rankType;
    }
    
    private void isWinner(int winningNumber) {
        if (IntegerUtils.arrToList(myNumbers).contains(winningNumber)) {
            rank++;
        }
    }

    private void setRank(int rank) {
        for (Rank rank1 : Rank.values()) {
            if (rank1.getMatchNumber() == rank) {
                rankType = rank1;
                break;
            }
        }
    }
}
