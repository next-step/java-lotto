package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoNumber {

    private static final int MIN_ELEMENT = 1;
    private static final int MAX_ELEMENT = 45;
    private List<Integer> lotto;

    public LottoNumber(List<Integer> lotto){
        for(int input:lotto){
            checkBound(input);
        }
        this.lotto = lotto;
    }

    private void checkBound(int input){
        if(input < MIN_ELEMENT || input > MAX_ELEMENT){
            throw new IllegalArgumentException("로또는 1~45 사이 원소 사용");
        }
    }

    public List<Integer> getLotto() {
        return lotto;
    }

    public boolean lottoContains(int element){
        return lotto.contains(element);
    }

}
