package lotto.model;

import lotto.service.LottoNumberPicker;

import java.util.List;

public class Lotto {

    private final List<Integer> lotto;
    public Lotto(List<Integer> lottoNum) {
        this.lotto = lottoNum;
    }
    public List<Integer> getLotto() {
        return lotto;
    }

    public long getMatchedCount(List<Integer> input){
        boolean[] isVisited = new boolean[LottoNumberPicker.MAX_BOUND_NUM];
        for (Integer param : this.lotto) {
            isVisited[param] = true;
        }
        int count = 0;
        for (Integer param : input) {
            if (isVisited[param]){
                count++;
                isVisited[param] = false;
            }
        }
        return count;
    }
}