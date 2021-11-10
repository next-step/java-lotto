package lotto.domain;

import lotto.vo.LottoNumber;
import lotto.vo.LottoRule;

import java.util.Collections;
import java.util.List;

public class Lotto {

    private static final String RANGE_EXCEPTION_MESSAGE = "로또의 숫자 개수가 맞지 않습니다.";

    private final List<LottoNumber> lottoNumbers;

    private Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto create(List<LottoNumber> lottoNumberList) {

        if (lottoNumberList == null || lottoNumberList.size() != LottoRule.LOTTO_COUNT.getValue()) {
            throw new IllegalArgumentException(RANGE_EXCEPTION_MESSAGE);
        }

        return new Lotto(lottoNumberList);
    }

    public void sort() {
        Collections.sort(this.lottoNumbers);
    }

    public long getCountOfMatch(Lotto winningLotto) {
        return lottoNumbers.stream()
                .filter(winningLotto.lottoNumbers::contains)
                .count();
    }
}
