package lottoAuto.model;

import java.util.List;

public class LottoResult {
    private int count;
    private boolean hasBonusBall;

    public LottoResult(int count) {
        this.count = count;
    }

    public void containBonusBall(List<Lotto> lottos, int bonusBall) {
        lottos.stream()
                .forEach(lotto -> this.hasBonusBall = lotto.hasBonusBall(bonusBall));
    }

    public int getCount() {
        return count;
    }

    public boolean isHasBonusBall() {
        return hasBonusBall;
    }
}
