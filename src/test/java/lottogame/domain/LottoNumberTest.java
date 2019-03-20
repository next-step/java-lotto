package lottogame.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lottogame.domain.LottoNumber.MAXIMUM_LOTTO_NUMBER;
import static lottogame.domain.LottoNumber.MINIMUM_LOTTO_NUMBER;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LottoNumberTest {
    private LottoNumber lottoNumber;

    @Test
    public void isInvalid() {
        List<Integer> invalidLottoNumbers =
                Arrays.asList(MINIMUM_LOTTO_NUMBER-1, MAXIMUM_LOTTO_NUMBER+1);

        for(int curNumber : invalidLottoNumbers) {
            assertTrue(lottoNumber.isInvalid(curNumber));
        }

        List<Integer> validLottoNumbers = getValidLottoNumbers();

        for(int curNumber : validLottoNumbers) {
            assertFalse(lottoNumber.isInvalid(curNumber));
        }
    }

    @Test
    public void equalsNumber() {
        List<Integer> validLottoNumbers = getValidLottoNumbers();

        for( int curNumber : validLottoNumbers ) {
            lottoNumber = new LottoNumber(curNumber);
            assertTrue(lottoNumber.equalsNumber(curNumber));
        }
    }

    private List<Integer> getValidLottoNumbers() {
        return IntStream.rangeClosed(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }
}