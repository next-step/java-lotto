package lottery;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class LotteryRow {
    public static final Integer ROW_SIZE = 6;

    private final Set<LotteryNumber> row;

    private LotteryRow(Set<LotteryNumber> numbers) {
        checkHasRowSize(numbers);
        row = numbers;
    }

    public static LotteryRow fromGiven(Set<Integer> numbers) {
        var givenLotteryNumbers = numbers.stream().map(LotteryNumber::fromGiven).collect(Collectors.toSet());
        return new LotteryRow(givenLotteryNumbers);
    }

    public static LotteryRow fromRandom() {
        var randomLotteryNumbers = new HashSet<LotteryNumber>();
        while (randomLotteryNumbers.size() < ROW_SIZE) {
            randomLotteryNumbers.add(LotteryNumber.fromRandom());
        }
        return new LotteryRow(randomLotteryNumbers);
    }

    public static LotteryRow fromCommaSpliced(String numbers) {
        return new LotteryRow(Arrays.stream(numbers.replace(" ", "").split(","))
                .map(Integer::parseInt)
                .map(LotteryNumber::fromGiven)
                .collect(Collectors.toSet()));
    }

    public Set<Integer> getNumbers() {
        return row.stream().map(LotteryNumber::value).collect(Collectors.toSet());
    }

    public Integer getMatchCount(LotteryRow otherRow) {
        var myRow = new HashSet<>(row);
        myRow.retainAll(otherRow.row);
        return myRow.size();
    }

    private void checkHasRowSize(Set<LotteryNumber> numbers) {
        if (numbers.size() != ROW_SIZE) {
            throw new IllegalArgumentException("Row size not equal to defined size");
        }
    }
}
