package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.error.SizeExceedLottoException;

public class Lotto {

    private List<LottoNumber> lotto;

    public Lotto(List<LottoNumber> lotto) {
        if(lotto.size() > 6){
            throw new SizeExceedLottoException(lotto.size());
        }
        this.lotto = lotto;
    }

    public static Lotto fromValues(List<Integer> values) {
        List<LottoNumber> lottoNumbers = values.stream()
            .map(LottoNumber::formInt)
            .collect(Collectors.toList());
        return new Lotto(lottoNumbers);
    }

    public int size(){
        return lotto.size();
    }

}
