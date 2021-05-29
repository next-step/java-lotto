package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos() {
        this.lottos = new ArrayList<>();
    }

    public Lottos(Lotto lotto) {
        this.lottos = new ArrayList<>();
        this.lottos.add(lotto);
    }

    public boolean isCount(int expectedCount) {
        return getCount() == expectedCount;
    }

    public void createRandomLotto() {
        this.lottos.add(new Lotto());
    }

    public LottoRecord compareWinLotto(Lotto winLotto, LottoNumber bonusNumber) {
        LottoRecord userLottoRecord = new LottoRecord();
        for (Lotto userLotto : lottos) {
            userLottoRecord.recordRank(userLotto.compareWinLotto(winLotto, bonusNumber));
        }
        userLottoRecord.calculateProfit(lottos.size());
        return userLottoRecord;
    }

    public int getCount() {
        return lottos.size();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Lotto lottoNumber : lottos) {
            stringBuilder.append(lottoNumber.toString());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
