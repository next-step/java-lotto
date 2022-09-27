package lotto.model;

import lotto.service.LottoNumberPicker;

import java.util.List;
import java.util.stream.IntStream;

public class Lotto {

    private final List<Integer> lotto;


    public Lotto(List<Integer> lottoNum) {
        if (lottoNum.size() != LottoNumberPicker.LOTTO_LENGTH) {
            throw new IllegalArgumentException("유효하지 않은 로또 숫자입니다.");
        }
        this.lotto = lottoNum;
    }

    public List<Integer> getLotto() {
        return lotto;
    }

    public Integer getMatchedCount(Lotto target) {
        return Long.valueOf(this.lotto.stream().filter((num)-> target.lotto.contains(num)).count()).intValue();
    }

}
