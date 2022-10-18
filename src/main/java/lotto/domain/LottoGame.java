package lotto.domain;

import java.util.List;

public class LottoGame {

    private int autoAmount;
    private int manualCount;
    private Lottos manualLottos;
    private Lottos autoLottos;

    public LottoGame(int autoAmount, int manualCount) {
        this.autoAmount = autoAmount;
        this.manualCount = manualCount;
    }

    public void createLottos(List<String> manualNumbers) {
        this.manualLottos = new Lottos().createManualLottos(manualNumbers);
        this.autoLottos = new Lottos().createAutoLottos(autoAmount);
    }

    public Lottos getManualLottos() {
        return this.manualLottos;
    }

    public Lottos getAutoLottos() {
        return this.autoLottos;
    }

    public int getManualCount() {
        return this.manualCount;
    }

    public int getAutoCount() {
        return this.autoAmount / Lottos.LOTTO_PRICE;
    }

    public LottoResults getResult(Lotto winning, LottoNumber bonus) {
        LottoResults lottoResults = new LottoResults();
        int sameNumbers = 0;
        boolean winBonus = false;

        for (Lotto lotto : manualLottos.getLottoList()) {
            sameNumbers = lotto.getSameNumberCount(winning);
            winBonus = lotto.getLottoNumbers().contains(bonus);
            Rank rank = Rank.valueOf(sameNumbers, winBonus);
            lottoResults.addRank(rank);
        }

        for (Lotto lotto : autoLottos.getLottoList()) {
            sameNumbers = lotto.getSameNumberCount(winning);
            winBonus = lotto.getLottoNumbers().contains(bonus);
            Rank rank = Rank.valueOf(sameNumbers, winBonus);
            lottoResults.addRank(rank);
        }

        return lottoResults;
    }
}
