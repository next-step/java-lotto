package lotto.domain.lotto.service;

import lotto.domain.lotto.*;
import lotto.domain.lotto.dto.LottoRequestDto;
import lotto.domain.result.*;

import java.util.Map;

public class LottoService {

    private final LottoRequestDto lottoRequestDto;

    public LottoService(LottoRequestDto lottoRequestDto) {
        this.lottoRequestDto = lottoRequestDto;
    }

    public LottoGroup makeLottoGroup() {
        Store store = new Store(new DivideLottoCount());

        Money changes = store.orderManual(new Money(lottoRequestDto.getPurchaseMoney())
                , lottoRequestDto.getManualOrderCount());
        LottoBundle autoLottoBundle = store.order(changes);
        ManualLottoBundle manualLottoBundle =
                new ManualLottoBundle(lottoRequestDto.getManualLottos());

        return new LottoGroup(manualLottoBundle, autoLottoBundle);
    }

    public Record makeRecord(LottoGroup lottoGroup, String answerNumbers, String bonusWinNumber) {
        WinNumber winNumber = LottoCompany.announce(answerNumbers, bonusWinNumber);
        return Record.extractRecord(lottoGroup.getGroupBundle(), winNumber);
    }

    public ProfitRate calculate(Map<Rank, Integer> rankMap) {
        ProfitCalculator profitCalculator = new ProfitCalculator(new MultiplyProfitRate());
        return profitCalculator.calculate(rankMap, lottoRequestDto.getPurchaseMoney());
    }

}
