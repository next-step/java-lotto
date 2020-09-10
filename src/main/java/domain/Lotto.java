package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int SIX = 6;

    private Set<LottoNo> lottoNumber;

    public Lotto(Set<LottoNo> lotto) {
        validateLottoNumber(lotto);
        this.lottoNumber = lotto;
    }

    private void validateLottoNumber(Set<LottoNo> lotto) {
        validateEmpty(lotto);
        validateSize(lotto);
        validateNumberRange(lotto);
    }

    private void validateEmpty(Set<LottoNo> lotto) {
        if (lotto == null || lotto.size() == 0) {
            throw new IllegalArgumentException("empty!");
        }
    }

    private void validateSize(Set<LottoNo> lotto) {
        if (lotto.size() != SIX) {
            throw new IllegalArgumentException("not 6 number");
        }
    }

    public List<LottoNo> getLottoNumber() {
        return new ArrayList<>(lottoNumber);
    }

    private void validateNumberRange(Set<LottoNo> lotto) {
        boolean rangeValidate = lotto.stream()
                .allMatch(c->c.validateNumber());

        if (!rangeValidate) {
            throw new IllegalArgumentException("숫자 1~45내 범위 입력 오류!!");
        }
    }

    boolean hasBonusNumber(int bonus) {
        return lottoNumber.contains(new LottoNo(bonus));
    }
}
