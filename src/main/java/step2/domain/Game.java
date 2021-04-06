package step2.domain;

import static java.util.stream.Collectors.toList;
import static step2.util.StringConstant.DELIMITER_COMMA;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Game {

    private final List<Number> numbers;
    private Rank rank;

    public Game(int length) {
        this.numbers = init(length);
    }

    public Game(String manualGame) {
        this.numbers = init(manualGame);
    }

    public Game(List<Integer> numbers) {
        this.numbers = init(numbers);
    }

    public void match(Game prize, Number bonus) {
        long count = numbers.stream()
            .filter(prize.numbers::contains)
            .count();

        boolean matchBonus = numbers.stream()
            .anyMatch(bonus::equals);

        this.rank = Rank.valueOf(Long.valueOf(count).intValue(), matchBonus);
    }

    public double profit() {
        return rank.getWinningMoney() * 1.0;
    }

    public List<Number> numbers() {
        return this.numbers;
    }

    public Rank rank() {
        return this.rank;
    }

    private List<Number> init(int length) {
        return LottoGenerator.generateLotto(length);
    }

    private List<Number> init(List<Integer> numbers) {
        return numbers.stream()
            .map(Number::new)
            .collect(toList());
    }

    private List<Number> init(String manualGame) {
        return Arrays.stream(manualGame.split(DELIMITER_COMMA))
            .map(Integer::parseInt)
            .map(Number::new)
            .collect(toList());
    }

    @Override
    public String toString() {
        return "[ " +
            numbers.stream()
                .map(Number::toString)
                .collect(Collectors.joining(","))
            + " ]";
    }
}
