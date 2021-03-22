package step2.domain;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        List<Integer> numbers = toInteger(input);
        this.lastPrize = new Game(numbers);
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

    private List<Integer> toInteger(String input) {
        return Arrays.stream(input.split(DELIMITER))
            .map(Integer::parseInt)
            .collect(toList());
    }
}
