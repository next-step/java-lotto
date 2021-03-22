package step2.domain;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Lotto {

    private final List<Game> games;

    public Lotto() {
        this.games = new ArrayList<>();
    }

    public void init(int gameSize, int lengthPerGame) {
        IntStream.range(0, gameSize)
            .mapToObj(ignore -> new Game(lengthPerGame))
            .collect(collectingAndThen(toList(), games::addAll));
    }

    public int size() {
        return games.size();
    }

    public List<Game> games() {
        return this.games;
    }
}
