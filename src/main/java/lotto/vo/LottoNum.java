package lotto.vo;

import java.util.HashMap;
import java.util.Map;

/**
 * LottoNum 따라서 만들어봄.
 * 추후 구현 이유와 방법, 적용에 대해서 학습 필요.
 */
public class LottoNum {

    private static final Map<Integer, LottoNum> lottoNums = new HashMap<>();

    static {
        for (int i = 1; i < 46; i++){
            lottoNums.put(i,new LottoNum(i));
        }
    }

    private int num;
    public LottoNum(int num) {
        if(num < 1 || num > 45){
            throw new IllegalArgumentException();
        }
        this.num = num;
    }

    public static LottoNum of(int num){
        return lottoNums.get(num);
    }

    public int getNum() {
        return num;
    }
}
