package lotto.domain;

import lotto.vo.LottoNumber;

import java.util.List;

public class Lotto {

    private static final String RANGE_EXCEPTION_MESSAGE = "로또의 숫자 개수는 6개여야 합니다.";

    private final List<LottoNumber> lottoNumbers;

    private Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto create(List<LottoNumber> lottoNumberList) {

        if(lottoNumberList == null || lottoNumberList.size() != 6) {
            throw new IllegalArgumentException(RANGE_EXCEPTION_MESSAGE);
        }

        return new Lotto(lottoNumberList);
    }
}
