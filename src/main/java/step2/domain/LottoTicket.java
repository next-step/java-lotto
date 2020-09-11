package step2.domain;

import step2.Constant;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
    private List<Integer> numbers;
    private int prizeResult;

    public LottoTicket(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getPrizeResult() {
        return prizeResult;
    }

    public void checkWinningTicket(List<Integer> officialWinningNumbers, int bonusNumber) {
        List<Integer> sameNumbers = new ArrayList<>();

        officialWinningNumbers.forEach(winningNumber -> collectWinningNumbers(winningNumber, sameNumbers));

        if (sameNumbers.size() >= Constant.COUNT_THREE) {
            setWinningPrize(sameNumbers.size(), bonusNumber);
        }
    }

    private void setWinningPrize(int count, int bonusNumber) {
        if (count == Constant.COUNT_THREE) {
            prizeResult = Constant.LOTTO_PRIZE_FIFTH;
        }

        if (count == Constant.COUNT_FOUR) {
            prizeResult = Constant.LOTTO_PRIZE_FOURTH;
        }

        if (count == Constant.COUNT_FIVE) {
            checkBonusNumber(bonusNumber);
        }

        if (count == Constant.COUNT_SIX) {
            prizeResult = Constant.LOTTO_PRIZE_FIRST;
        }
    }

    private void checkBonusNumber(int bonusNumber){
        if(numbers.contains(bonusNumber)){
            prizeResult = Constant.LOTTO_PRIZE_SECOND;
            return;
        }
        prizeResult = Constant.LOTTO_PRIZE_THIRD;
    }

    private void collectWinningNumbers(int winningNumber, List<Integer> sameNumbers) {
        if (numbers.contains(winningNumber)) {
            sameNumbers.add(winningNumber);
        }
    }

}
