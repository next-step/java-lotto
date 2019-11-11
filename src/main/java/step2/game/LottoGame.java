package step2.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static step2.game.Number.createVerifiedNumbers;

public class LottoGame {
    static final int MAX_NUMBER = 45;
    static final int MIN_NUMBER = 1;
    static final int NUMBER_COUNT = 6;
    private static final String JOINER = ", ";
    private static final List<Number> balls = createVerifiedNumbers();
    private static final int START_INDEX = 0;
    private List<Number> numbers;

    public LottoGame() {
        numbers = pickRandomNumbers();
    }

    static LottoGame ofRandom() {
        LottoGame lottoGame = new LottoGame();
        lottoGame.numbers = pickRandomNumbers();
        return lottoGame;
    }

    public static LottoGame ofManual(List<Number> inputNumbers) {
        LottoGame lottoGame = new LottoGame();
        lottoGame.numbers = inputNumbers;
        return lottoGame;
    }

    private static List<Number> pickRandomNumbers() {
        Collections.shuffle(balls);
        List<Number> number = new ArrayList<>(balls.subList(START_INDEX, NUMBER_COUNT));
        number.sort(Number::compareTo);
        return number;
    }

    public String toString() {
        return numbers.stream().map(Number::toString).reduce((o1, o2) -> o1 + JOINER + o2)
                .orElseThrow(IllegalArgumentException::new);
    }

    public int matchWinningNumberCount(WinningLotto winningLotto) {
        return Math.toIntExact(numbers.stream().filter(winningLotto::contains).count());
    }

    boolean containsBonus(WinningLotto winningLotto) {
        return winningLotto.hasBonus(numbers);
    }
}
