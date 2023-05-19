package lotto.domain.lotto.service;

import lotto.domain.lotto.*;
import lotto.domain.lotto.dto.LottoRequestDto;
import lotto.domain.result.*;
import lotto.ui.OutputView;

import java.util.Map;

public class LottoService {

    private final LottoRequestDto lottoRequestDto;
    private final LottoCompany lottoCompany = LottoCompany.getInstance();

    public LottoService(LottoRequestDto lottoRequestDto) {
        this.lottoRequestDto = lottoRequestDto;
    }

    public LottoGroup makeLottoGroup() {
        Money changes = Store.orderManual(new Money(lottoRequestDto.getPurchaseMoney())
                , lottoRequestDto.getManualOrderCount());
        LottoBundle autoLottoBundle = Store.order(changes);
        ManualLottoBundle manualLottoBundle =
                lottoCompany.makeManualBundle(lottoRequestDto.getManualLottos());

        return new LottoGroup(manualLottoBundle, autoLottoBundle);
    }

    public Record makeRecord(LottoGroup lottoGroup, String answerNumbers, String bonusWinNumber) {
        WinNumber winNumber = lottoCompany.announce(answerNumbers, bonusWinNumber);
        return Record.extractRecord(lottoGroup.getGroupBundle(), winNumber);
    }

    public ProfitRate calculate(Map<Rank, Integer> rankMap) {
        ProfitCalculator profitCalculator = new ProfitCalculator(new MultiplyStrategy());
        return profitCalculator.calculate(rankMap, lottoRequestDto.getPurchaseMoney());
    }

}
