package lottogame.service;

import lottogame.domain.LottoNumber;
import lottogame.domain.LottoNumberPackage;
import org.junit.Test;

import java.util.Set;

import static lottogame.domain.LottoNumber.MAXIMUM_LOTTO_NUMBER;
import static lottogame.domain.LottoNumber.MINIMUM_LOTTO_NUMBER;
import static lottogame.domain.LottoNumberPackage.LOTTO_GAME_SIZE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LottoNumberGeneratorImplTest {

    private LottoNumberGeneratorImpl lottoNumberGenerator;

    @Test
    public void generate() {
        lottoNumberGenerator = new LottoNumberGeneratorImpl();

        LottoNumberPackage lottoNumberPackage = lottoNumberGenerator.generate();
        System.out.println(lottoNumberPackage);

        assertEquals(LOTTO_GAME_SIZE, lottoNumberPackage.getNumbers().size());
        for(LottoNumber curNumber : lottoNumberPackage.getNumbers()) {
            assertTrue(LottoNumberGeneratorImpl.getNumberPool().contains(curNumber.getNumber()));
        }
    }

    @Test
    public void getLottoNumbers() {
        lottoNumberGenerator = new LottoNumberGeneratorImpl();

        Set<LottoNumber> lottoNumbers = lottoNumberGenerator.getLottoNumbers();
        System.out.println(lottoNumbers);

        assertEquals(LOTTO_GAME_SIZE, lottoNumbers.size());
        for(LottoNumber curNumber : lottoNumbers) {
            assertThat(curNumber.getNumber()).isBetween(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER);
        }
    }

}