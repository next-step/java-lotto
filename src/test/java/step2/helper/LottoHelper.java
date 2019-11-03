package step2.helper;

import step2.domain.LottoNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoHelper {

    public static List<LottoNumber> makeLottoNumbersHelper(int one, int two, int three, int four, int five, int six) {
        LottoNumber lottoOne = new LottoNumber(one);
        LottoNumber lottoTwo = new LottoNumber(two);
        LottoNumber lottoThree = new LottoNumber(three);
        LottoNumber lottoFour = new LottoNumber(four);
        LottoNumber lottoFive = new LottoNumber(five);
        LottoNumber lottoSix = new LottoNumber(six);
        return new ArrayList<>(Arrays.asList(lottoOne, lottoTwo, lottoThree, lottoFour, lottoFive, lottoSix));
    }

}
