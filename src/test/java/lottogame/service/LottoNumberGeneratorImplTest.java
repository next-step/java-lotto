package lottogame.service;

import lottogame.domain.LottoNumber;
import lottogame.domain.LottoNumberPackage;
import org.junit.Test;

import java.util.Set;

import static lottogame.domain.LottoNumberPackage.LOTTO_GAME_SIZE;
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

        Set<Integer> lottoNumbers = lottoNumberGenerator.getLottoNumbers();
        System.out.println(lottoNumbers);

        assertEquals(LOTTO_GAME_SIZE, lottoNumbers.size());
        for(int curNumber : lottoNumbers) {
            assertEquals(curNumber, new LottoNumber(curNumber).getNumber());
        }
    }

}