package lotto.domain.strategy;

import lotto.domain.LottoNumber;

import java.util.Arrays;
import java.util.List;

/**
 * 테스트 사용 전용 객체
 */
public class TestStrategy extends LottoStrategy {

    public final List<LottoNumber> lottoNumbers = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));

    @Override
    public List<LottoNumber> lottoNumbers() {
        return this.lottoNumbers;
    }
}
