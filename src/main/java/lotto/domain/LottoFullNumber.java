package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoFullNumber {

    private final List<LottoNumber> lottoFullNumber;

    public LottoFullNumber(List<LottoNumber> lottoFullNumber) {
        List<LottoNumber> lottoFullNumberLengthSix = lottoFullNumber.subList(0,6);
        Collections.sort(lottoFullNumberLengthSix);
        this.lottoFullNumber = new ArrayList<>(lottoFullNumberLengthSix);
    }

    private void validateNonDuplication(List<LottoNumber> lottoFullNumberLengthSix) {
        Set<LottoNumber> LottoNumberSet = new HashSet<>(lottoFullNumberLengthSix);
        if (LottoNumberSet.size() != LOTTO_NUMBER_SIZE){
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    public List<Integer> getLottoFullNumber() {
        return lottoFullNumber
            .stream()
            .map(LottoNumber::getValue)
            .collect(Collectors.toList());
    }
}
