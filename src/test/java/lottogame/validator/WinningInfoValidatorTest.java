package lottogame.validator;

import lottogame.domain.LottoNumber;
import lottogame.domain.LottoNumberPackage;
import lottogame.domain.WinningInfo;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WinningInfoValidatorTest {

    private final WinningInfoValidator validator = new WinningInfoValidator();
    private LottoNumberPackage winningNumbers;

    @Before
    public void setUp() {
        winningNumbers = new LottoNumberPackage(getRangedNumbers(1, 6));
    }

    @Test
    public void isValid_for_null() {
        assertFalse(validator.isValid(null));
    }

    @Test(expected = IllegalArgumentException.class)
    public void isValid_for_containing_bonusNumber1() {
        getWinningInfo(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void isValid_for_containing_bonusNumber2() {
        getWinningInfo(6);
    }


    @Test
    public void isValid_for_not_containing_bonusNumber() {
        assertTrue(validator.isValid(getWinningInfo(7)));
    }

    private Set<LottoNumber> getRangedNumbers(int from, int to) {
        return IntStream.rangeClosed(from, to)
                .boxed()
                .map(LottoNumber::getInstance)
                .collect(Collectors.toSet());
    }

    private WinningInfo getWinningInfo(int bonusNumber) {
        return new WinningInfo(winningNumbers, LottoNumber.getInstance(bonusNumber));
    }
}