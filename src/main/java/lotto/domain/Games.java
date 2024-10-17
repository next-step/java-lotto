package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Games {

    private final List<Game> games;

    public Games(int money, RandomNumberGenerator generator) {
        int numberOfGames = money / Game.PRICE;

        List<Game> games = new ArrayList<>();
        for (int i = 0; i < numberOfGames; i++) {
            List<Integer> randomNumbers = generator.generate(Game.NUMBER_OF_LOTTONUMBER, LottoNumber.MIN, LottoNumber.MAX);
            games.add(new Game(randomNumbers));
        }

        if (games.isEmpty()) {
            throw new IllegalArgumentException(String.format("최소 %d원이 필요합니다.", Game.PRICE));
        }

        this.games = Collections.unmodifiableList(games);
    }

    public Games(Game... games) {
        this.games = List.of(games);
    }

    public int count() {
        return games.size();
    }

    public List<Rank> checkResult(Game winner) {
        return games.stream()
                .map(game -> game.countIdenticalLottoNumber(winner))
                .map(hits -> Rank.of(hits))
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public String toString() {
        return games.stream()
                .map(Game::toString)
                .collect(Collectors.joining("\n"));
    }
}
