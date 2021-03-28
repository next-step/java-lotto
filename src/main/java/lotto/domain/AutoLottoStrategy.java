/*
 * 로또 자동 생성 전략을 나타내는 클래스
 * */
package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class AutoLottoStrategy implements LottoStrategy {

    @Override
    public List<LottoNumber> makeLotto(List<LottoNumber> lottoNumbers) {
        Collections.shuffle(lottoNumbers, new Random());
        return new ArrayList<>(lottoNumbers.subList(0, LOTTO_SIZE));
    }
}
