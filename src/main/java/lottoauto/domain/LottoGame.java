package lottoauto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private final int money;
    private final int lottoCount;
    private final int lottoAutoCount;
    private final int lottoManualCount;

    public LottoGame(int money, int tryManualCount) {
        if (money < Lotto.PRICE) {
            throw new IllegalArgumentException("로또를 살 수 없습니다.");
        }
        this.money = money;
        this.lottoCount = money / Lotto.PRICE;
        this.lottoManualCount = tryManualCount;
        this.lottoAutoCount = this.lottoCount - tryManualCount;
    }

    public Lottos start(List<Lotto> manualLottos){
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.addAll(manualLottos);
        for (int i = 0; i < lottoAutoCount; i++) {
            lottoList.add(LottoGenerator.makeLotto());
        }
        Lottos lottos = new Lottos(lottoList);
        return lottos;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public int getProfitRate(Lottos lottos) {
        int totalWinningMoney = LottoStatus.FIFTH.getWinningMoney() * lottos.getWinningMap().get(LottoStatus.FIFTH)
                + LottoStatus.FOURTH.getWinningMoney() * lottos.getWinningMap().get(LottoStatus.FOURTH)
                + LottoStatus.THIRD.getWinningMoney() * lottos.getWinningMap().get(LottoStatus.THIRD)
                + LottoStatus.SECOND.getWinningMoney() * lottos.getWinningMap().get(LottoStatus.SECOND)
                + LottoStatus.FIRST.getWinningMoney() * lottos.getWinningMap().get(LottoStatus.FIRST);
        return totalWinningMoney / this.money;
    }

}
