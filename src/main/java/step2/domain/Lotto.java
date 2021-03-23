package step2.domain;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static step2.util.StringConstant.NEW_LINE;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
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

    public Map<Integer, List<Game>> candidate(Prize prize) {
        return games.stream()
            .collect(Collectors.groupingBy(game -> game.containCount(prize.last())));
    }

    public int size() {
        return games.size();
    }

    public List<Game> games() {
        return this.games;
    }

    @Override
    public String toString() {
        return games.stream()
            .map(Game::toString)
            .collect(Collectors.joining(NEW_LINE));
    }
}
