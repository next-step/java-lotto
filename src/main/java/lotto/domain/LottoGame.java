package lotto.domain;

import lotto.constant.Rank;
import lotto.exception.InvalidManualLottoNumberCount;

import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {

    private final Cash purchaseAmount;
    private final Lottos lottos;

    public LottoGame(Cash purchaseAmount, List<LottoNumbers> manualLottoNumbers) {
        if (purchaseAmount.overTotalCount(manualLottoNumbers)) {
            throw new InvalidManualLottoNumberCount(purchaseAmount.totalLottoCount());
        }

        List<Lotto> lottos = manualLottoNumbers.stream()
                .map(Lotto::valueOf)
                .collect(Collectors.toList());
        while (lottos.size() < purchaseAmount.totalLottoCount()) {
            lottos.add(Lotto.createAutoLotto());
        }
        this.lottos = new Lottos(lottos);
        this.purchaseAmount = purchaseAmount;
    }

    public void confirmLottos(LottoNumbers lastWinningNumbers, LottoNumber bonusNumber) {
        lottos.confirmAll(lastWinningNumbers, bonusNumber);
    }

    public double calculateProfitRate() {
        return (double) lottos.calculateTotalWinPrice() / purchaseAmount.toDouble();
    }

    public Lottos lottos() {
        return lottos;
    }

    public int countMatchResult(Rank rank) {
        return lottos.countMatchResult(rank);
    }

    public int manualLottoCount() {
        return lottos.countManualLotto();
    }

    public int autoLottoCount() {
        return lottos.count() - lottos.countManualLotto();
    }
}
