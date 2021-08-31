package lottery_bonus.domain;

import java.util.List;
import java.util.stream.Collectors;

public final class Lotteries {

    private static final int BONUS_NUMBER_CRITERIA = 5;
    private static final double BONUS_NUMMBER_SCORE = 0.5;

    private List<Lottery> lotteryList;

    public Lotteries(final List<Lottery> lotteryList) {
        this.lotteryList = lotteryList;
    }

    public WinningResult drawWinningResult(final List<Integer> winningNumber, final int bonusNumber){
        List<Double> scoreList = scoreWinningNumber(winningNumber);

        for (int score = 0; score < scoreList.size(); score++) {
            scoreList.set(score, scoreBonusNumber(scoreList.get(score), lotteryList.get(score), bonusNumber));
        }

        return new WinningResult(scoreList);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        lotteryList.stream()
                .map(Lottery::toString)
                .map(lottery -> lottery + System.lineSeparator())
                .forEach(stringBuilder::append);

        return stringBuilder.toString();
    }

    private List<Double> scoreWinningNumber(final List<Integer> winningNumber){
        return lotteryList.stream()
                .map(lottery -> lottery.compareWinningNumber(winningNumber))
                .collect(Collectors.toList());
    }

    private double scoreBonusNumber(final double score, final Lottery lottery, final int bonusNumber) {

        if(score == BONUS_NUMBER_CRITERIA && lottery.compareBonusNumber(bonusNumber)){
            return score + BONUS_NUMMBER_SCORE;
        }
        return score;
    }
}
