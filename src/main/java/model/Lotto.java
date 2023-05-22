package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<LottoNumber> lotto = new ArrayList<>();

    public Lotto(List<Integer> lotto) {
        for (int num : lotto) {
            this.lotto.add(new LottoNumber(num));
        }
    }

    public List<LottoNumber> getLotto() {
        return this.lotto;
    }

    public List<Integer> getWinNumIntegerType() {
        return lotto.stream()
                .map(LottoNumber::getLottoNumber)
                .collect(Collectors.toList());
    }

    public Boolean contains(LottoNumber number) {
        return this.lotto.stream()
                .anyMatch(lottoNumber -> lottoNumber.getLottoNumber() == number.getLottoNumber());
    }

}
