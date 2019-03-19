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

    @Test
    public void isInvalid_for_string_array() {
        assertTrue(LottoGame.isInvalid((String[])null));
        assertTrue(LottoGame.isInvalid(new String[]{}));
        assertTrue(LottoGame.isInvalid(new String[]{"1", "2", "3", "4", "5"}));
        assertTrue(LottoGame.isInvalid(new String[]{"1", "2", "3", "4", "5", "6", "7"}));
        assertFalse(LottoGame.isInvalid(new String[]{"1", "2", "3", "4", "5", "6"}));
    }

    @Test
    public void isInvalid_for_integer_list() {
        assertTrue(LottoGame.isInvalid((List<Integer>)null));
        assertTrue(LottoGame.isInvalid(Collections.emptyList()));
        assertTrue(LottoGame.isInvalid(Arrays.asList(1, 2, 3, 4, 5)));
        assertTrue(LottoGame.isInvalid(Arrays.asList(1, 2, 3, 4, 5, 6, 7)));
        assertFalse(LottoGame.isInvalid(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @Test
    public void getGameNumbers_for_empty_string_array() {
        List<LottoNumber> expected = Collections.emptyList();

        List<LottoNumber> actualForNull = LottoGame.getGameNumbers((String[])null);
        List<LottoNumber> actualForEmpty = LottoGame.getGameNumbers(new String[]{});
        List<LottoNumber> actualForEmpty2 = LottoGame.getGameNumbers(new String[]{"", "", "", "", "", ""});

        assertEquals(expected, actualForNull);
        assertEquals(expected, actualForEmpty);
        assertEquals(expected, actualForEmpty2);
    }

    @Test
    public void getGameNumbers_for_string_array() {
        List<LottoNumber> expected = Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)
        );

        List<LottoNumber> actual = LottoGame.getGameNumbers(new String[]{"1", "2", "3", "4", "5", "6"});

        assertEquals(expected, actual);
    }

    @Test
    public void getGameNumbers_for_empty_integer_list() {
        List<LottoNumber> expected = Collections.emptyList();

        List<LottoNumber> actualForNull = LottoGame.getGameNumbers((List<Integer>)null);
        List<LottoNumber> actualForEmpty = LottoGame.getGameNumbers(Collections.emptyList());

        assertEquals(expected, actualForNull);
        assertEquals(expected, actualForEmpty);
    }

    @Test
    public void getGameNumbers_for_integer_list() {
        List<LottoNumber> expected = Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)
        );

        List<LottoNumber> actual = LottoGame.getGameNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertEquals(expected, actual);
    }

    @Test
    public void getMatchedCount() {
        List<Integer> gameNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> targetNumbers0 = Arrays.asList(40, 41, 42, 43, 44, 45);
        List<Integer> targetNumbers1 = Arrays.asList(1, 41, 42, 43, 44, 45);
        List<Integer> targetNumbers2 = Arrays.asList(1, 2, 42, 43, 44, 45);
        List<Integer> targetNumbers3 = Arrays.asList(40, 41, 3, 4, 5, 45);
        List<Integer> targetNumbers4 = Arrays.asList(40, 2, 3, 43, 5, 6);
        List<Integer> targetNumbers5 = Arrays.asList(1, 2, 42, 4, 5, 6);
        List<Integer> targetNumbers6 = Arrays.asList(1, 2, 3, 4, 5, 6);

        LottoGame game = new LottoGame(gameNumbers);
        LottoGame targetGame0 = new LottoGame(targetNumbers0);
        LottoGame targetGame1 = new LottoGame(targetNumbers1);
        LottoGame targetGame2 = new LottoGame(targetNumbers2);
        LottoGame targetGame3 = new LottoGame(targetNumbers3);
        LottoGame targetGame4 = new LottoGame(targetNumbers4);
        LottoGame targetGame5 = new LottoGame(targetNumbers5);
        LottoGame targetGame6 = new LottoGame(targetNumbers6);

        assertEquals(0, game.getMatchedCount(targetGame0));
        assertEquals(1, game.getMatchedCount(targetGame1));
        assertEquals(2, game.getMatchedCount(targetGame2));
        assertEquals(3, game.getMatchedCount(targetGame3));
        assertEquals(4, game.getMatchedCount(targetGame4));
        assertEquals(5, game.getMatchedCount(targetGame5));
        assertEquals(6, game.getMatchedCount(targetGame6));
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