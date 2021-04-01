/*
 * 로또 자동 생성 전략을 나타내는 클래스
 * */
package lotto.domain;

import java.util.*;

import static lotto.domain.LottoNumbers.LOTTO_SIZE;

public class AutoLottoStrategy implements LottoStrategy {

    @Override
    public LottoNumbers makeLotto(List<LottoNumber> lottoNumbers) {
        Collections.shuffle(lottoNumbers, new Random());
        Set<LottoNumber> lottoNumberSet = new LinkedHashSet<>(lottoNumbers.subList(0, LOTTO_SIZE));
        return new LottoNumbers(lottoNumberSet);
    }
}
