package lottogame.domain;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lottogame.domain.LottoNumber.MAXIMUM_LOTTO_NUMBER;
import static lottogame.domain.LottoNumber.MINIMUM_LOTTO_NUMBER;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LottoNumberTest {

    private LottoNumber lottoNumber;

    @Test(expected = IllegalArgumentException.class)
    public void constructor_of_LottoNumber_for_less_than_minimum() {
        int invalidNumber = MINIMUM_LOTTO_NUMBER-1;
        LottoNumber.getInstance(invalidNumber);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_of_LottoNumber_for_more_than_maximum() {
        int invalidNumber = MAXIMUM_LOTTO_NUMBER+1;
        LottoNumber.getInstance(invalidNumber);
    }

    @Test
    public void constructor_of_LottoNumber() {
        List<Integer> validLottoNumbers = getValidLottoNumbers();

        for(int curNumber : validLottoNumbers) {
            lottoNumber = LottoNumber.getInstance(curNumber);
            assertEquals(curNumber, lottoNumber.getNumber());
        }
    }

    @Test
    public void equalsNumber() {
        List<Integer> validLottoNumbers = getValidLottoNumbers();

        for( int curNumber : validLottoNumbers ) {
            lottoNumber = LottoNumber.getInstance(curNumber);
            assertTrue(lottoNumber.equalsNumber(curNumber));
        }
    }

    private List<Integer> getValidLottoNumbers() {
        return IntStream.rangeClosed(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }
}