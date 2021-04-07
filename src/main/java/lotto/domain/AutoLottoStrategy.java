/*
 * 로또 자동 생성 전략을 나타내는 클래스
 * */
package lotto.domain;

import static lotto.domain.LottoFactory.defaultLottoNumbers;
import static lotto.domain.LottoNumbers.LOTTO_SIZE;

public class AutoLottoStrategy implements LottoStrategy {

    @Override
    public Lotto makeLotto() {
        defaultLottoNumbers.shuffleNumbers();
        LottoNumbers lottoNumbers = defaultLottoNumbers.takeNumbers(LOTTO_SIZE);
        return new Lotto(lottoNumbers);
    }
}
