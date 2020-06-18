package lotto.model;

import utils.IntegerUtils;

public class LottoTicket {
    private int rank = 0;
    private Rank rankType;

    private LottoNumbers myNumbers = new LottoNumbers();

    public LottoTicket() { }
    public LottoTicket(LottoNumbers numbers) {
        this.myNumbers = numbers;
    }

    public LottoNumbers getMyNumbers() {
        return myNumbers;
    }

    public Rank announceRank(int[] winningNumbers) {
        for (int i : winningNumbers) {
            isWinner(i);
        }

        rankType = Rank.getValue(rank);
        return rankType;
    }
    
    private void isWinner(int winningNumber) {
        if (IntegerUtils.numbersToList(myNumbers.getNumbers()).contains(winningNumber)) {
            rank++;
        }
    }
}
