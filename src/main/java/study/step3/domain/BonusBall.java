package study.step3.domain;

import java.util.List;
import java.util.Set;

public class BonusBall {
    private final static String LOTTO_BONUS_BALL_EXCEPTION = "이미 입력한 번호는 보너스로 입력 불가합니다.";

    private final LottoNumber bonusNumber;

    public BonusBall(int bonusNumber) {
        this(new LottoNumber(bonusNumber));
    }

    private BonusBall(LottoNumber bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public void validateDuplicationBonusBall(List<LottoNumber> lottoNumbers) {
        if(lottoNumbers.contains(bonusNumber)){
            throw new IllegalArgumentException(LOTTO_BONUS_BALL_EXCEPTION);
        }
    }

    public boolean isMatch(Set<LottoNumber> lottoNumbers) {
        return lottoNumbers.contains(bonusNumber);
    }
}
