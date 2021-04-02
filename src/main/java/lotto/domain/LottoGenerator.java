package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator implements Generator {
    private final static int PRICE = 1000;

    private final int tryNum;

    public LottoGenerator(int payNum) {
        this.tryNum = payNum / PRICE;
    }

    public List<Lotto> generateLotto() {
        List<Lotto> lottoList = new ArrayList<>();

        for (int num = 0; num < tryNum; num++) {
            lottoList.add(Lottoinjection.provideLotto());
        }
        return lottoList;
    }

}
