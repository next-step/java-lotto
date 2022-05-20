package lotto.model;

import java.util.List;
import java.util.Optional;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Lottery {
    public final TreeSet<LotteryNumber> lotteryNumbers;

    public Lottery() {
        this.lotteryNumbers = createLottery();
    }

    public Lottery(TreeSet<LotteryNumber> lotteryNumbers) {
        this.lotteryNumbers = lotteryNumbers;
    }

    public static TreeSet<LotteryNumber> toLotteryNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(number -> new LotteryNumber(number))
                .collect(Collectors.toCollection(TreeSet::new));
    }

    private TreeSet<LotteryNumber> createLottery() {
        return LotteryBox.createLottery();
    }

    @Override
    public String toString() {
        return lotteryNumbers + "";
    }

    public Reward findWin(Winning winning) {
        return winning.matchWin(this);
    }

    public int countMatches(Lottery answer) {
        int match = 0;
        for (LotteryNumber lotteryNumber:this.lotteryNumbers
             ) {
            match += this.countMatch(lotteryNumber, answer);
        }
        return  match;

    }

    private int countMatch(LotteryNumber lotteryNumber, Lottery answer) {
        if (answer.lotteryNumbers.contains(lotteryNumber)) {
            return 1;
        }
        return 0;
    }

    public Optional<Reward> bonus(int bonusNumber) {
            if (this.lotteryNumbers.contains(new LotteryNumber(bonusNumber))) {
                return Optional.ofNullable(Reward.of(5, true));
            }
            return null;
    }
}


