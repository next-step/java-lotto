/*
 * 로또 자동 생성 전략을 나타내는 클래스
 * */
package lotto.domain;

import static lotto.domain.LottoNumbers.LOTTO_SIZE;

public class AutoLottoStrategy implements LottoStrategy {

    @Override
    public LottoNumbers makeLotto(LottoNumbers lottoNumbers) {
        lottoNumbers.shuffleNumbers();
        return lottoNumbers.takeNumbers(LOTTO_SIZE);
    }
}
