package step2.game;

import step2.analyze.Prize;
import step2.analyze.WinningCount;
import step2.numbers.LottoGame;
import step2.numbers.Number;
import step2.numbers.WinningLotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static step2.numbers.Number.createVerifiedNumbers;

public class AutoGames implements GameStrategy {
    private static final int NUMBER_COUNT = 6;
    private static final List<Number> balls = createVerifiedNumbers();
    private static final int START_INDEX = 0;
    private List<LottoGame> games;

    public AutoGames(int autoCount) {
        games = new ArrayList<>();
        for ( int count = 0; count < autoCount; count++ ) {
            addGame();
        }
    }

    private void addGame() {
        games.add(new LottoGame(pickRandomNumbers()));
    }

    private List<Number> pickRandomNumbers() {
        Collections.shuffle(balls);
        List<Number> number = new ArrayList<>(balls.subList(START_INDEX, NUMBER_COUNT));
        number.sort(Number :: compareTo);
        return number;
    }

    public void checkWinningCount(WinningCount winningCount, WinningLotto winningLotto) {
        for ( LottoGame lottoGame : games ) {
            Prize prize
                    = Prize.of(lottoGame.matchWinningNumberCount(winningLotto), lottoGame.containsBonus(winningLotto));
            winningCount.addCount(prize);
        }
    }

    public int size() {
        return games.size();
    }

    public String toString(int index) {
        return games.get(index).toString();
    }
}
