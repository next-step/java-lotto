package lotto.model;

import utils.IntegerUtils;

import java.util.List;

public class LottoTicket {
    private int rank = 0;
    private Rank rankType;

    private LottoNumbers myNumbers;

    public LottoTicket() {
        this.myNumbers = new LottoNumbers();
    }

    public LottoTicket(LottoNumbers numbers) {
        this.myNumbers = numbers;
    }

    public LottoNumbers getMyNumbers() {
        return myNumbers;
    }

    public Rank announceRank(LottoNumbers winningNumbers, LottoNumber bonusBall) {
        for (LottoNumber number : winningNumbers.getNumbers()) {
            isWinner(number);
        }

        rankType = Rank.getValue(rank, isBonus(bonusBall));
        return rankType;
    }

    private boolean isBonus(LottoNumber bonusBall) {
        List<Integer> myNumberList = IntegerUtils.numbersToList(myNumbers.getNumbers());
        return myNumberList.contains(bonusBall.getNumber());
    }

    private void isWinner(LottoNumber winningNumber) {
        List<Integer> myNumberList = IntegerUtils.numbersToList(myNumbers.getNumbers());
        if (myNumberList.contains(winningNumber.getNumber())) {
            rank++;
        }
    }
}
