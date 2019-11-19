package step2.game;

import step2.numbers.LottoGame;
import step2.numbers.Number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static step2.numbers.Number.createVerifiedNumbers;

public class AutoGames implements GameStrategy {
    public static final String STRATEGY = "AUTO";
    private static final int NUMBER_COUNT = 6;
    private static final List<Number> balls = createVerifiedNumbers();
    private static final int START_INDEX = 0;
    private final List<LottoGame> games;

    public AutoGames(int autoCount) {
        List<LottoGame> lottoGames = new ArrayList<>();
        for (int count = 0; count < autoCount; count++) {
            lottoGames.add(new LottoGame(pickRandomNumbers()));
        }
        this.games = lottoGames;
    }

    @Override
    public List<LottoGame> getGames() {
        return games;
    }

    private List<Number> pickRandomNumbers() {
        Collections.shuffle(balls);
        List<Number> number = new ArrayList<>(balls.subList(START_INDEX, NUMBER_COUNT));
        number.sort(Number::compareTo);
        return number;
    }

    public int size() {
        return games.size();
    }

    public String toString(int index) {
        return games.get(index).toString();
    }
}
