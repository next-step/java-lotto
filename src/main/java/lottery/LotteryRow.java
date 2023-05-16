package lottery;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class LotteryRow {
    public static final Integer ROW_SIZE = 6;

    private final SortedSet<LotteryNumber> row;

    private LotteryRow(SortedSet<LotteryNumber> numbers) {
        checkHasRowSize(numbers);
        row = numbers;
    }

    public static LotteryRow fromGiven(Set<Integer> numbers) {
        var givenLotteryNumbers = numbers.stream()
                .map(LotteryNumber::fromGiven)
                .collect(Collectors.toCollection(TreeSet::new));
        return new LotteryRow(givenLotteryNumbers);
    }

    public static LotteryRow fromRandom() {
        var randomLotteryNumbers = new TreeSet<LotteryNumber>();
        while (randomLotteryNumbers.size() < ROW_SIZE) {
            randomLotteryNumbers.add(LotteryNumber.fromRandom());
        }
        return new LotteryRow(randomLotteryNumbers);
    }

    public SortedSet<Integer> getNumbers() {
        return row.stream().map(LotteryNumber::value).collect(Collectors.toCollection(TreeSet::new));
    }

    public Integer getMatchCount(LotteryRow otherRow) {
        var myRow = new HashSet<>(row);
        myRow.retainAll(otherRow.row);
        return myRow.size();
    }

    public Boolean isBonusHit(LotteryNumber bonus) {
        return row.contains(bonus);
    }

    private void checkHasRowSize(Set<LotteryNumber> numbers) {
        if (numbers.size() != ROW_SIZE) {
            throw new IllegalArgumentException("Row size not equal to defined size");
        }
    }
}
