package step2.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static step2.game.Number.createVerifiedNumbers;

public class LottoGame {
    static final int MAX_NUMBER = 45;
    static final int MIN_NUMBER = 1;
    static final int NUMBER_COUNT = 6;
    private static final String NUMBER_COUNT_EXCEPTION = "입력된 로또번호가 6개가 아닙니다.";
    private static final String DUPLICATED_NUMBER_EXCEPTION = "로또번호는 중복된 숫자를 허용하지 않습니다.";
    private static final String DELIMITER = ",";
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

    public static LottoGame ofManual(String inputNumbers) {
        LottoGame lottoGame = new LottoGame();

        lottoGame.numbers = Arrays.stream(inputNumbers.split(DELIMITER))
                .map(num -> Integer.parseInt(num.trim()))
                .map(Number::valueOf)
                .collect(toList());
        verifyLottoNumberCount(lottoGame.numbers);
        return lottoGame;
    }

    private static void verifyLottoNumberCount(List<Number> inputWinningNumbers) {
        if (inputWinningNumbers.size() != LottoGame.NUMBER_COUNT) {
            throw new IllegalArgumentException(NUMBER_COUNT_EXCEPTION);
        }
        if (inputWinningNumbers.stream().distinct().count() != LottoGame.NUMBER_COUNT) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER_EXCEPTION);
        }
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
