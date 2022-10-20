package lotto.model;

import lotto.exception.InvalidLottoSizeException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private List<LottoNumber> lotto;

    public Lotto(List<LottoNumber> lotto) {
        this.lotto = new ArrayList<>(lotto);

        validateLottoSize();
    }

    public Lotto(String[] lotto) {
        this.lotto = Arrays.stream(lotto)
                .map(number -> new LottoNumber(number))
                .collect(Collectors.toList());

        validateLottoSize();
    }

    private void validateLottoSize(){
        if (this.lotto.size() != 6) {
            throw new InvalidLottoSizeException(String.format("[사이즈 오류] 로또는 6개의 숫자가 생성되어야 합니다. %s", lotto.size()));
        }
    }

    public List<LottoNumber> getLotto() {
        return lotto;
    }
}
