package lotto.domain;

import lotto.dto.LottoRequestDto;
import lotto.dto.WinningLottoDto;

import java.util.List;

public class LottoStore {
    public Lottos buy(LottoRequestDto request) {
        int autoQuantity = getAutoQuantity(request);

        return LottoFactory.create(autoQuantity, request.lottoNumbers());
    }

    private int getAutoQuantity(LottoRequestDto request) {
        return (request.money() - getManualLottoPrice(request.lottoNumbers())) / Lotto.PRICE;
    }

    private int getManualLottoPrice(List<String> manualLottoNumbers) {
        return manualLottoNumbers.size() * Lotto.PRICE;
    }

    public LottoStatistics createStatistics(Lottos lottos, WinningLottoDto winningLottoDto) {
        WinningLotto winningLotto = WinningLotto.from(winningLottoDto);

        return new LottoStatistics(lottos, winningLotto);
    }
}
