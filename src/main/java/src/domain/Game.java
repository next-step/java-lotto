package src.domain;

import java.util.HashSet;
import java.util.Set;

public class Game {

    private static final int GAME_NUMBER_SIZE = 6;

    private final Set<GameNumber> numbers;

    private int matchCount;

    private Game(Set<GameNumber> numbers) {
        this.numbers = numbers;
        this.matchCount = 0;
    }

    public static Game newGame() {
        Set<GameNumber> values = new HashSet<>(GAME_NUMBER_SIZE);
        while (values.size() < GAME_NUMBER_SIZE) {
            values.add(GameNumber.random());
        }

        return new Game(values);
    }

    public static Game byGameNumbers(Set<GameNumber> gameNumbers) {
        if (gameNumbers.size() < GAME_NUMBER_SIZE) {
            throw new IllegalArgumentException("6개의 게임 넘버가 필요합니다.");
        }

        return new Game(gameNumbers);
    }

    public int numberSize() {
        return numbers.size();
    }

    public int matchCount() {
        return matchCount;
    }

    public void match(Game winningGame) {
        for (GameNumber winningNumber: winningGame.numbers) {
            matchNumber(winningNumber);
        }
    }

    private void matchNumber(GameNumber winningNumber) {
        if (numbers.contains(winningNumber)) {
            matchCount++;
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
