package lotto.step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private List<Integer> lotto = new ArrayList<>();

    public Lotto(List<Integer> lotto) {
        this.lotto = validateLottoNumbers(lotto);
    }

    public List<Integer> getLotto() {
        return List.copyOf(lotto);
    }

    private List<Integer> validateLottoNumbers(List<Integer> lottoNumber) {
        if (size(lottoNumber)) {
            throw new IllegalArgumentException("당첨 번호는 6개만 가능합니다.");
        }
        if (isInRange(lottoNumber)) {
            throw new IllegalArgumentException("당첨 번호는 1 ~ 45까지만 가능합니다.");
        }
        return lottoNumber;
    }

    private boolean size(List<Integer> lottoNumber) {
        return lottoNumber.size() != 6;
    }

    private boolean isInRange(List<Integer> lottoNumber) {
        return Collections.max(lottoNumber) > 45 || Collections.min(lottoNumber) < 1;
    }

}
