package lotto.model;

import lotto.service.LottoNumberPicker;

import java.util.List;
import java.util.stream.IntStream;

public class Lotto {

    private final List<Integer> lotto;

    private final boolean[] checkedTable;
    public Lotto(List<Integer> lottoNum) {
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
        return IntStream.range(0,this.checkedTable.length).filter((idx)->isMatched(lotto,idx)).reduce(Integer::sum).orElse(0);
    }

    private boolean isMatched(Lotto lotto, int index) {
       return this.checkedTable[index] && lotto.checkedTable[index];
    }

}