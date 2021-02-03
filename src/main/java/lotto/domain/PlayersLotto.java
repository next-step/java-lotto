package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayersLotto extends Lotto {


    private final List<LottoNumber> numbers;

    public List<LottoNumber> getNumbers() {
        return numbers;
    }

    public PlayersLotto(List<LottoNumber> lottoNumbers) {
        checkSizeOfLotto(lottoNumbers);
        checkDuplicatedNumber(lottoNumbers);
        this.numbers = lottoNumbers;
    }

    public List<Integer> getAsIntegerList() {
        List<Integer> lottoNumberList = new ArrayList<>();
        numbers.forEach(lottoNumber -> {
            lottoNumberList.add(lottoNumber.getLottoNumber());
        });
        Collections.sort(lottoNumberList);
        return lottoNumberList;
    }

    public static PlayersLotto of (List<LottoNumber> numbers) {
        return new PlayersLotto(numbers);
    }

}
