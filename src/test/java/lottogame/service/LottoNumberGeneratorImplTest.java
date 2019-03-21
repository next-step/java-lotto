package lottogame.service;

import lottogame.domain.LottoNumber;
import org.junit.Test;

import java.util.List;

import static lottogame.domain.LottoNumberPackage.LOTTO_GAME_SIZE;
import static org.junit.Assert.*;

public class LottoNumberGeneratorImplTest {

    private LottoNumberGeneratorImpl lottoNumberGenerator;

    @Test
    public void getLottoNumbers() {
        lottoNumberGenerator = new LottoNumberGeneratorImpl();

        List<Integer> lottoNumbers = lottoNumberGenerator.getLottoNumbers();
        System.out.println(lottoNumbers);

        assertEquals(LOTTO_GAME_SIZE, lottoNumbers.size());
        for(int curNumber : lottoNumbers) {
            assertEquals(curNumber, new LottoNumber(curNumber).getNumber());
        }
    }
}