package lotto.domain;

import lotto.dto.LottoRequestDto;
import lotto.dto.WinningLottoDto;

import java.util.List;

public class LottoStore {
    public Lottos buy(LottoRequestDto request) {
        List<String> manualLottoNumbers = request.lottoNumbers();

        int autoCount = getAutoCount(request, manualLottoNumbers);

        return LottoFactory.create(autoCount, manualLottoNumbers);
    }

    private int getAutoCount(LottoRequestDto request, List<String> manualLottoNumbers) {
        return (request.money() - getManualLottoPrice(manualLottoNumbers)) / Lotto.PRICE;
    }

    private int getManualLottoPrice(List<String> manualLottoNumbers) {
        return manualLottoNumbers.size() * Lotto.PRICE;
    }

    public LottoStatistics createStatistics(Lottos lottos, WinningLottoDto winningLottoDto) {
        WinningLotto winningLotto = WinningLotto.from(winningLottoDto);

        return new LottoStatistics(lottos, winningLotto);
    }
}
