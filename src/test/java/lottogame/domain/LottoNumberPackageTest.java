package lottogame.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lottogame.domain.LottoNumberPackage.LOTTO_GAME_SIZE;
import static lottogame.domain.LottoNumber.MAXIMUM_LOTTO_NUMBER;
import static lottogame.domain.LottoNumber.MINIMUM_LOTTO_NUMBER;
import static org.junit.Assert.*;

public class LottoNumberPackageTest {

    @Test(expected = IllegalArgumentException.class)
    public void LottoGame_for_null() {
        new LottoNumberPackage((Set<Integer>)null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void LottoGame_for_empty() {
        new LottoNumberPackage(Collections.emptySet());
    }

    @Test(expected = IllegalArgumentException.class)
    public void LottoGame_for_insufficient_length_of_integers() {
        new LottoNumberPackage(getRangedNumbers(1, 5));
    }

    @Test(expected = IllegalArgumentException.class)
    public void LottoGame_for_too_many_length_of_integers() {
        new LottoNumberPackage(getRangedNumbers(1, 7));
    }

    @Test
    public void LottoGame_for_integer_array() {
        Set<LottoNumber> expected = getSet(
            Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)
            )
        );
        Set<Integer> lottoNumbers = getRangedNumbers(1, 6);
        Set<LottoNumber> actual = new LottoNumberPackage(lottoNumbers).getNumbers();

        assertEquals(expected, actual);
    }

    @Test
    public void getMatchedCount_0() {
        Set<Integer> gameNumbers = getRangedNumbers(1, 6);
        LottoNumberPackage game = new LottoNumberPackage(gameNumbers);

        Set<Integer> targetNumbers = getRangedNumbers(40, 45);
        LottoNumberPackage targetGame = new LottoNumberPackage(targetNumbers);

        assertEquals(0, game.getMatchedCount(targetGame));
    }

    @Test
    public void getMatchedCount_1() {
        Set<Integer> gameNumbers = getRangedNumbers(1, 6);
        LottoNumberPackage game = new LottoNumberPackage(gameNumbers);

        Set<Integer> targetNumbers = getRangedNumbers(41, 45);
        targetNumbers.add(1);
        LottoNumberPackage targetGame = new LottoNumberPackage(targetNumbers);

        assertEquals(1, game.getMatchedCount(targetGame));
    }

    @Test
    public void getMatchedCount_6() {
        Set<Integer> gameNumbers = getRangedNumbers(1, 6);
        LottoNumberPackage game = new LottoNumberPackage(gameNumbers);

        Set<Integer> targetNumbers = getRangedNumbers(1, 6);
        LottoNumberPackage targetGame = new LottoNumberPackage(targetNumbers);

        assertEquals(6, game.getMatchedCount(targetGame));
    }

    @Test
    public void contains() {
        Set<Integer> gameNumbers = getRangedNumbers(MINIMUM_LOTTO_NUMBER, LOTTO_GAME_SIZE);
        LottoNumberPackage lottoNumberPackage = new LottoNumberPackage(gameNumbers);

        for(int curTargetNumber : gameNumbers) {
            assertTrue(lottoNumberPackage.contains(new LottoNumber(curTargetNumber)));
        }

        Set<Integer> uncontainedTargetNumbers = getRangedNumbers(LOTTO_GAME_SIZE + 1, MAXIMUM_LOTTO_NUMBER);

        for(int curTargetNumber : uncontainedTargetNumbers) {
            assertFalse(lottoNumberPackage.contains(new LottoNumber(curTargetNumber)));
        }
    }

    private Set<LottoNumber> getSet(List<LottoNumber> list) {
        return new HashSet(list);
    }

    private Set<Integer> getRangedNumbers(int from, int to) {
        return IntStream.rangeClosed(from, to)
                .boxed()
                .collect(Collectors.toSet());
    }
}