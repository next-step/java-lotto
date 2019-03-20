package lottogame.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lottogame.domain.LottoGame.LOTTO_GAME_SIZE;
import static lottogame.domain.LottoNumber.MAXIMUM_LOTTO_NUMBER;
import static lottogame.domain.LottoNumber.MINIMUM_LOTTO_NUMBER;
import static org.junit.Assert.*;

public class LottoGameTest {

    @Test(expected = IllegalArgumentException.class)
    public void LottoGame_for_null_integer_array() {
        new LottoGame((List<Integer>)null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void LottoGame_for_empty_integer_array() {
        new LottoGame(Collections.emptyList());
    }

    @Test(expected = IllegalArgumentException.class)
    public void LottoGame_for_insufficient_length_of_integer_array() {
        new LottoGame(Arrays.asList(1, 2, 3, 4, 5));
    }

    @Test(expected = IllegalArgumentException.class)
    public void LottoGame_for_too_many_length_of_integer_array() {
        new LottoGame(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
    }

    @Test
    public void LottoGame_for_integer_array() {
        List<LottoNumber> expected = Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)
        );
        List lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<LottoNumber> actual = new LottoGame(lottoNumbers).getGameNumbers();

        assertEquals(expected, actual);
    }

    @Test
    public void getMatchedCount_0() {
        List<Integer> gameNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        LottoGame game = new LottoGame(gameNumbers);

        List<Integer> targetNumbers = Arrays.asList(40, 41, 42, 43, 44, 45);
        LottoGame targetGame = new LottoGame(targetNumbers);

        assertEquals(0, game.getMatchedCount(targetGame));
    }

    @Test
    public void getMatchedCount_1() {
        List<Integer> gameNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        LottoGame game = new LottoGame(gameNumbers);

        List<Integer> targetNumbers = Arrays.asList(1, 41, 42, 43, 44, 45);
        LottoGame targetGame = new LottoGame(targetNumbers);

        assertEquals(1, game.getMatchedCount(targetGame));
    }

    @Test
    public void getMatchedCount_6() {
        List<Integer> gameNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        LottoGame game = new LottoGame(gameNumbers);

        List<Integer> targetNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        LottoGame targetGame = new LottoGame(targetNumbers);

        assertEquals(6, game.getMatchedCount(targetGame));
    }

    @Test
    public void contains() {
        List<Integer> gameNumbers = getRangedNumbers(MINIMUM_LOTTO_NUMBER, LOTTO_GAME_SIZE);
        LottoGame game = new LottoGame(gameNumbers);

        for(int curTargetNumber : gameNumbers) {
            assertTrue(game.contains(new LottoNumber(curTargetNumber)));
        }

        List<Integer> uncontainedTargetNumbers = getRangedNumbers(LOTTO_GAME_SIZE + 1, MAXIMUM_LOTTO_NUMBER);

        for(int curTargetNumber : uncontainedTargetNumbers) {
            assertFalse(game.contains(new LottoNumber(curTargetNumber)));
        }
    }

    private List<Integer> getRangedNumbers(int from, int to) {
        return IntStream.rangeClosed(from, to)
                .boxed()
                .collect(Collectors.toList());
    }
}