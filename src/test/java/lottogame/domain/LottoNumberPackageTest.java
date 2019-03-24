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

    @Test(expected = NullPointerException.class)
    public void LottoGame_for_null_InputLine() {
        new LottoNumberPackage((String)null);
    }

    @Test(expected = NumberFormatException.class)
    public void LottoGame_for_string_inputLine() {
        new LottoNumberPackage("aaa");
    }

    @Test(expected = IllegalArgumentException.class)
    public void LottoGame_for_InputLine_smaller_than_LOTTO_GAME_SIZE() {
        new LottoNumberPackage("1, 2, 3, 4, 5");
    }

    @Test(expected = IllegalArgumentException.class)
    public void LottoGame_for_InputLine_larger_than_LOTTO_GAME_SIZE() {
        new LottoNumberPackage("1, 2, 3, 4, 5, 6, 7");
    }

    @Test
    public void LottoGame_for_InputLine() {
        Set<LottoNumber> expected = getRangedNumbers(1, 6);

        LottoNumberPackage lottoNumberPackage = new LottoNumberPackage("1,2,3,4,5,6");

        assertEquals(expected.toString(), lottoNumberPackage.getNumbers().toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void LottoGame_for_null_set() {
        new LottoNumberPackage((Set<LottoNumber>)null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void LottoGame_for_empty() {
        new LottoNumberPackage(Collections.emptySet());
    }

    @Test(expected = IllegalArgumentException.class)
    public void LottoGame_for_integers_less_than_LOTTO_GAME_SIZE_() {
        new LottoNumberPackage(getRangedNumbers(1, 5));
    }

    @Test(expected = IllegalArgumentException.class)
    public void LottoGame_for_too_many_length_of_integers() {
        new LottoNumberPackage(getRangedNumbers(1, 7));
    }

    @Test
    public void LottoGame_for_integers() {
        Set<LottoNumber> expected = getSet(
            Arrays.asList(
                LottoNumber.getInstance(1), LottoNumber.getInstance(2), LottoNumber.getInstance(3),
                LottoNumber.getInstance(4), LottoNumber.getInstance(5), LottoNumber.getInstance(6)
            )
        );
        Set<LottoNumber> lottoNumbers = getRangedNumbers(1, 6);
        Set<LottoNumber> actual = new LottoNumberPackage(lottoNumbers).getNumbers();

        assertEquals(expected, actual);
    }

    @Test
    public void getMatchedCount_0() {
        Set<LottoNumber> gameNumbers = getRangedNumbers(1, 6);
        LottoNumberPackage game = new LottoNumberPackage(gameNumbers);

        Set<LottoNumber> targetNumbers = getRangedNumbers(40, 45);
        LottoNumberPackage targetGame = new LottoNumberPackage(targetNumbers);

        assertEquals(0, game.getMatchedCount(targetGame));
    }

    @Test
    public void getMatchedCount_1() {
        Set<LottoNumber> gameNumbers = getRangedNumbers(1, 6);
        LottoNumberPackage game = new LottoNumberPackage(gameNumbers);

        Set<LottoNumber> targetNumbers = getRangedNumbers(41, 45);
        targetNumbers.add(LottoNumber.getInstance(1));
        LottoNumberPackage targetGame = new LottoNumberPackage(targetNumbers);

        assertEquals(1, game.getMatchedCount(targetGame));
    }

    @Test
    public void getMatchedCount_6() {
        Set<LottoNumber> gameNumbers = getRangedNumbers(1, 6);
        LottoNumberPackage game = new LottoNumberPackage(gameNumbers);

        Set<LottoNumber> targetNumbers = getRangedNumbers(1, 6);
        LottoNumberPackage targetGame = new LottoNumberPackage(targetNumbers);

        assertEquals(6, game.getMatchedCount(targetGame));
    }

    @Test
    public void contains() {
        Set<LottoNumber> gameNumbers = getRangedNumbers(MINIMUM_LOTTO_NUMBER, LOTTO_GAME_SIZE);
        LottoNumberPackage lottoNumberPackage = new LottoNumberPackage(gameNumbers);

        for(LottoNumber curTargetNumber : gameNumbers) {
            assertTrue(lottoNumberPackage.contains(curTargetNumber));
        }

        Set<LottoNumber> uncontainedTargetNumbers = getRangedNumbers(LOTTO_GAME_SIZE + 1, MAXIMUM_LOTTO_NUMBER);

        for(LottoNumber curTargetNumber : uncontainedTargetNumbers) {
            assertFalse(lottoNumberPackage.contains(curTargetNumber));
        }
    }

    private Set<LottoNumber> getSet(List<LottoNumber> list) {
        return new HashSet(list);
    }

    private Set<LottoNumber> getRangedNumbers(int from, int to) {
        return IntStream.rangeClosed(from, to)
                .boxed()
                .map(LottoNumber::getInstance)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
}