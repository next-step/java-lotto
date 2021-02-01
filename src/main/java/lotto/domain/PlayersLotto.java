package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlayersLotto implements Lotto {


    private final List<LottoNumber> numbers;

    public PlayersLotto(List<LottoNumber> lottoNumbers) {
        checkSizeOfLotto(lottoNumbers);
        checkDuplicatedNumber(lottoNumbers);
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

    private void checkSizeOfLotto(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개이어야 합니다.");
        }
    }

    private void checkDuplicatedNumber(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> lottoNumbersChecker = new HashSet<>(lottoNumbers);
        if (lottoNumbersChecker.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("중복된 로또번호가 있습니다.");
        }

    }
}
