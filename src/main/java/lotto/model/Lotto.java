package lotto.model;

import lotto.service.LottoNumberPicker;

import java.util.List;
import java.util.stream.IntStream;

public class Lotto {

    private final List<Integer> lotto;

    private final boolean[] checkedTable;
    public Lotto(List<Integer> lottoNum) {
        if (lottoNum.size() != LottoNumberPicker.LOTTO_LENGTH){
            throw new IllegalArgumentException("유효하지 않은 로또 숫자입니다.");
        }
        this.lotto = lottoNum;
        this.checkedTable = new boolean[LottoNumberPicker.MAX_BOUND_NUM];
        for (Integer param : lottoNum) {
            checkedTable[param] = true;
        }
    }
    public List<Integer> getLotto() {
        return lotto;
    }

    public Integer getMatchedCount(Lotto lotto){
       return Long.valueOf(IntStream.range(0,this.checkedTable.length).filter((idx)->isMatched(lotto,idx)).count()).intValue();
    }

    private boolean isMatched(Lotto lotto, int index) {
       return this.checkedTable[index] && lotto.checkedTable[index];
    }

}
