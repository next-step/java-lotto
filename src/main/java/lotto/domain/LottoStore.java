package lotto.domain;

import lotto.dto.LottoRequestDto;
import lotto.dto.WinningLottoDto;

import java.util.List;

public class LottoStore {
    public Lottos buy(LottoRequestDto request) {
        List<String> manualLottoNumbers = request.lottoNumbers();
        Lottos manual = LottoMachine.createManualLottos(manualLottoNumbers);

        int money = request.money() - (manualLottoNumbers.size() * Lotto.PRICE);
        if (money < Lotto.PRICE) {
            return manual;
        }

        return LottoMachine.createAutoLottos(money)
                .add(manual);
    }

    public LottoStatistics createStatistics(Lottos lottos, WinningLottoDto winningLottoDto) {
        WinningLotto winningLotto = WinningLotto.from(winningLottoDto);

        return new LottoStatistics(lottos, winningLotto);
    }
}
