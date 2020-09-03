package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int LAST_NUMBER = 45;
    private static final int SIX = 6;
    private static final int ONE = 1;

    private Set<LottoNo> lottoNumber;
//    private Set<Integer> lottoNumber;

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
        if (lotto.size() == 0 || lotto == null) {
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
                .allMatch(c -> c.getNumber() <= LAST_NUMBER && c.getNumber() >= ONE);

        if (!rangeValidate) {
            throw new IllegalArgumentException("숫자 45내 범위 입력 오류!!");
        }
    }

    public boolean hasBonusNumber(int bonus){
        return lottoNumber.contains(new LottoNo(bonus));
    }
}
