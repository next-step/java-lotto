package lotto.domain;

import lotto.constant.LottoConstant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoAutoMachine extends LottoMachine{

    public LottoAutoMachine(int cashAmount) {
        super(cashAmount);
    }

    @Override
    public List<Lotto> create() {
        List<Lotto> lottoList = new ArrayList<>();
        int purchaseCount = calculatePurchaseCount();
        for (int i = 0; i < purchaseCount; i++) {
            Collections.shuffle(getBalls());
            List<Integer> lottoBalls = new ArrayList<>(getBalls().subList(0, LottoConstant.LOTTO_SIZE));
            lottoList.add(new Lotto(lottoBalls));
        }
        return lottoList;
    }
}
