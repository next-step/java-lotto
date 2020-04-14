package lotto.vo;

import lotto.domain.object.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoList {

    private final List<Lotto> lottoList;

    public LottoList(final int purchaseCount) {
        lottoList = new ArrayList<Lotto>(Arrays.asList(new Lotto[purchaseCount]));
    }

    public LottoList(final int[][] lottoLists) {
        lottoList = new ArrayList<Lotto>();
        for (int[] lotto : lottoLists) {
            lottoList.add(new Lotto(lotto));
        }
    }

    public int getCount() {
        return lottoList.size();
    }

    public int getTotalPrize(final int[] luckyNumbers) {
        int total = 0;
        for (Lotto lotto : lottoList) {
            total += lotto.getPrize(luckyNumbers);
        }
        return total;
    }

    public float getEarningsRate(final int totalPrize, final int totalPurchase) {
        return (float)totalPrize/totalPurchase;
    }
}
