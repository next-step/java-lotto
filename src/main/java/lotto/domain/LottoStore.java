package lotto.domain;

import lotto.dto.LottoRequestDto;
import lotto.dto.WinningLottoDto;

import java.util.List;

public class LottoStore {
    public Lottos buy(LottoRequestDto request) {
        List<String> manualLottoNumbers = request.lottoNumbers();
        Lottos manual = LottoMachine.createManualLottos(manualLottoNumbers);

        int money = request.money() - getManualLottoPrice(manualLottoNumbers);
        if (isNoMorePurchasable(money)) {
            return manual;
        }

        return LottoMachine.createAutoLottos(money)
                .add(manual);
    }

    private boolean isNoMorePurchasable(int money) {
        return money < Lotto.PRICE;
    }

    private int getManualLottoPrice(List<String> manualLottoNumbers) {
        return manualLottoNumbers.size() * Lotto.PRICE;
    }

    public LottoStatistics createStatistics(Lottos lottos, WinningLottoDto winningLottoDto) {
        WinningLotto winningLotto = WinningLotto.from(winningLottoDto);

        return new LottoStatistics(lottos, winningLotto);
    }
}
