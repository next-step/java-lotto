package step2.domain;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static step2.util.StringConstant.NEW_LINE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    private final List<Game> games;
    private Number autoGameCount;
    private Number manualGameCount;

    public Lotto() {
        this.games = new ArrayList<>();
    }

    public void initAutoGames(int amount, int pricePerGame, int lengthPerGame) {
        this.autoGameCount = new Number((amount / pricePerGame) - games.size());
        IntStream.range(0, autoGameCount.value())
            .mapToObj(ignore -> new Game(lengthPerGame))
            .collect(collectingAndThen(toList(), games::addAll));
    }

    public void initManualGames(String manualGames) {
        Arrays.stream(manualGames.split(NEW_LINE))
            .map(Game::new)
            .collect(collectingAndThen(toList(), games::addAll));
        this.manualGameCount = new Number(games.size());
    }

    public void match(Prize prize) {
        games.forEach(game -> game.match(prize.last(), prize.bonus()));
    }

    public Map<Rank, List<Game>> candidate() {
        return games.stream()
            .collect(Collectors.groupingBy(Game::rank));
    }

    public double profit() {
        return games.stream()
            .map(Game::profit)
            .reduce(Double::sum)
            .orElse(0D);
    }

    public int size() {
        return games.size();
    }

    public int autoGameSize() {
        return this.autoGameCount.value();
    }

    public int manualGameSize() {
        return this.manualGameCount.value();
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
