package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.util.Validator;

public class PlayersLotto implements Lotto {

    private final List<LottoNumber> numbers;

    public PlayersLotto(List<LottoNumber> lottoNumbers) {
        Validator.checkSizeOfLotto(lottoNumbers);
        Validator.checkDuplicatedNumber(lottoNumbers);
        this.numbers = lottoNumbers;
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }

    public List<Integer> getAsIntegerList() {
        List<Integer> lottoNumberList = new ArrayList<>();
        numbers.forEach(lottoNumber -> {
            lottoNumberList.add(lottoNumber.getLottoNumber());
        });
        Collections.sort(lottoNumberList);
        return lottoNumberList;
    }

}
