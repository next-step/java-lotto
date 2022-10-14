package lotto.domain;

import java.util.stream.Collectors;

public class LottoWinner extends Lotto {

    private final LottoNumber bonusNumber;
    private final String LOTTOWINNER_BONUSNUMBER_EXCEPTION = "보너스 번호는 다른 번호와 겹칠 수 없습니다.";

    public LottoWinner(LottoNumberSet lottoNumberSet, LottoNumber bonusNumber) {
        super(lottoNumberSet);
        if (lottoNumberSet.contain(bonusNumber)) {
            throw new IllegalArgumentException(LOTTOWINNER_BONUSNUMBER_EXCEPTION);
        }
        this.bonusNumber = bonusNumber;
    }

    public int rank(Lotto lotto) {
        if (this.lottoNumbers.match(lotto.numbers()) == 3) {
            return 5;
        }
        if (this.lottoNumbers.match(lotto.numbers()) == 4) {
            return 4;
        }
        if (this.lottoNumbers.match(lotto.numbers()) == 5) {
            if (lotto.numbers().contain(bonusNumber)) {
                return 2;
            }
            return 3;
        }
        if (this.lottoNumbers.match(lotto.numbers()) == 6) {
            return 1;
        }
        return 0;
    }
}
