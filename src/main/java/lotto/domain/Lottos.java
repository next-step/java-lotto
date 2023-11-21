package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private List<Lotto> lottoList;

    public Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public static List<Lotto> createLottos(int purchaseCount) {
        List<Lotto> newLottoList = new ArrayList<>();
        for (int i = 0; i < purchaseCount; i++) {
            newLottoList.add(new Lotto(Lotto.createLotto()));
        }
        return newLottoList;
    }

    public int getSize() {
        return lottoList.size();
    }

    public Lotto getLotto(int index) {
        return lottoList.get(index);
    }

    public LottoMatchNumbers matchNumbers(WinningNumbers winningNumberList) {
        LottoMatchNumbers lottoMatchNumbers = new LottoMatchNumbers();
        for (Lotto lotto : lottoList) {
            int matchCount = lotto.matchCount(winningNumberList);
            lottoMatchNumbers.put(matchCount);
        }
        return lottoMatchNumbers;
    }
}
