package lotto.controller;

import lotto.domain.lotto.LottoGroup;
import lotto.domain.lotto.dto.LottoRequestDto;
import lotto.domain.lotto.service.LottoService;
import lotto.domain.result.Record;
import lotto.ui.InputView;
import lotto.ui.OutputView;

import java.util.List;

public class LottoApplicationMain {

    public static void main(String[] args) {
        int purchaseMoney = InputView.questionOrder();
        int manualOrderCount = InputView.questionManualOrder();
        List<String> manualLottos = InputView.questionLottoNumbers(manualOrderCount);

        LottoService lottoService = new LottoService(
                new LottoRequestDto(purchaseMoney, manualOrderCount, manualLottos));
        LottoGroup lottoGroup = lottoService.makeLottoGroup();

        OutputView.showLottoGroup(lottoGroup);

        String answerNumbers = InputView.questionWinnerNumber();
        String bonusWinNumber = InputView.questionBonusNumber();

        Record record = lottoService.makeRecord(lottoGroup, answerNumbers, bonusWinNumber);
        OutputView.showRecord(record);
        OutputView.showProfitRate(lottoService.calculate(record.getRecord()));
    }
}