package lotto.model;

import lotto.util.MessageUtil;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lotto) {
        validateSizeSix(lotto);
        this.lottoNumbers = Collections.unmodifiableList(lotto);
    }

    private void validateSizeSix(List<LottoNumber> lotto){
        if(lotto.size() !=6){
            throw new IllegalArgumentException(MessageUtil.WARNING_LOTTO_SIZE);
        }
    }
}
