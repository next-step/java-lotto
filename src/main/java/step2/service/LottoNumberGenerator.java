package step2.service;

import step2.vo.LottoNumber;

import java.util.Set;

public class LottoNumberGenerator {

    public static Set<LottoNumber> generateSixNumbers() {
        return LottoNumber.getSixLottoNumbers();
    }
}
