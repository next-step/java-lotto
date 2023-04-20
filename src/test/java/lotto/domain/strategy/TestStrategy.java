package lotto.domain.strategy;

import lotto.domain.LottoNumber;

import java.util.Arrays;
import java.util.List;

/**
 * 테스트 사용 전용 객체
 */
public class TestStrategy extends LottoStrategy {

    @Override
    public List<LottoNumber> lottoNumbers() {
        return Arrays.asList(new LottoNumber[6]);
    }
}
