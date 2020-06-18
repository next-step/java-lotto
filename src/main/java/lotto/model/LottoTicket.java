package lotto.model;

import utils.IntegerUtils;

import java.util.List;

public class LottoTicket {
    private int rank = 0;
    private Rank rankType;

    private LottoNumbers myNumbers; // = new LottoNumbers();

    public LottoTicket() {
        this.myNumbers = new LottoNumbers();
    }

    public LottoTicket(LottoNumbers numbers) {
        this.myNumbers = numbers;
    }

    public LottoNumbers getMyNumbers() {
        return myNumbers;
    }

    public Rank announceRank(LottoNumbers winningNumbers) {
        for (LottoNumber number : winningNumbers.getNumbers()) {
            isWinner(number);
        }

        rankType = Rank.getValue(rank);
        return rankType;
    }
    
    private void isWinner(LottoNumber winningNumber) {
        List<Integer> myNumberList = IntegerUtils.numbersToList(myNumbers.getNumbers());
        if (myNumberList.contains(winningNumber.getNumber())) {
            rank++;
        }
    }
}
