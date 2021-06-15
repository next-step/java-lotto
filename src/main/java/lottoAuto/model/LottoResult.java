package lottoAuto.model;

import java.util.List;

public class LottoResult {
    private int count;
    private boolean hasBonusBall;

    public LottoResult(int count) {
        this.count = count;
    }

    public void add(List<Lotto> lottos, int bonusBall) {
        this.hasBonusBall = lottos.contains(bonusBall);
    }

    public int getCount() {
        return count;
    }

    public boolean isHasBonusBall() {
        return hasBonusBall;
    }
}
