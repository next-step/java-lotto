package lottogame.domain;

import org.junit.Test;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class WinningInfoTest {

    @Test(expected = IllegalArgumentException.class)
    public void constructor_of_WinningInfo_for_duplicated_bonus_number() {
        LottoNumberPackage lottoNumberPackage = new LottoNumberPackage(getRangedNumbers(1, 6));
        LottoNumber bonusNumber = LottoNumber.getInstance(1);

        new WinningInfo(lottoNumberPackage, bonusNumber);
    }

    @Test
    public void constructor_of_WinningInfo() {
        LottoNumberPackage lottoNumberPackage = new LottoNumberPackage(getRangedNumbers(1, 6));
        LottoNumber bonusNumber = LottoNumber.getInstance(7);

        WinningInfo winningInfo = new WinningInfo(lottoNumberPackage, bonusNumber);

        assertEquals(lottoNumberPackage, winningInfo.getNumbers());
        assertEquals(bonusNumber, winningInfo.getBonusNumber());
    }

    private Set<LottoNumber> getRangedNumbers(int from, int to) {
        return IntStream.rangeClosed(from, to)
                .boxed()
                .map(LottoNumber::getInstance)
                .collect(Collectors.toSet());
    }
}