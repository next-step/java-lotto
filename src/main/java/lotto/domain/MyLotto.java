package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class MyLotto {
    private static int LOTTO_PRICE = 1000;
    private List<Lotto> lottoList = new ArrayList<>();

    public MyLotto(int money){
        for(int i=0; i<money/LOTTO_PRICE; i++){
            lottoList.add(new Lotto());
        }
    }
}
