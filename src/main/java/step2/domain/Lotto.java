package step2.domain;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    private static final String DELIMITER = ",";

    private final List<Game> games;
    private Game lastPrize;

    public Lotto(int lengthPerGame) {
        this.games = new ArrayList<>();
        this.lastPrize = new Game(lengthPerGame);
    }

    public void init(int gameSize, int lengthPerGame) {
        IntStream.range(0, gameSize)
            .mapToObj(ignore -> new Game(lengthPerGame))
            .collect(collectingAndThen(toList(), games::addAll));
    }

    public void initLastPrize(String input) {
        List<Integer> numbers = toIntegerList(input);
        this.lastPrize = new Game(numbers);
    }

    public Map<Long, List<Game>> candidate() {
        return games.stream()
            .collect(Collectors.groupingBy(game -> game.containCount(lastPrize)));
    }

    public int size() {
        return games.size();
    }

    public List<Game> games() {
        return this.games;
    }

    public Game lastPrize() {
        return this.lastPrize;
    }

    private List<Integer> toIntegerList(String input) {
        return Arrays.stream(input.split(DELIMITER))
            .map(Integer::parseInt)
            .collect(toList());
    }
}
