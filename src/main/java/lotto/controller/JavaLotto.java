package lotto.controller;

import lotto.dto.LottoNumbersDto;
import lotto.dto.LottosDto;
import lotto.dto.PrizeMoneyDto;
import lotto.dto.ResultDto;
import lotto.entity.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class JavaLotto {

    private JavaLotto() {

    }

    public static void run() {
        int inputMoney = InputView.requestBuyMoney();
        int manualCount = InputView.requestManualCount();
        List<String[]> manualTexts = InputView.requestManualNumbers(manualCount);

        List<Lotto> lottos = LottoMachine.createLotto(inputMoney, manualCount, manualTexts);

        ResultView.printCreateLotto(manualCount, toDto(lottos));
        Set<LottoNumber> winningNumbers = LottoText.ofValues(InputView.requestWinnerNumber());

        Winning winning = new Winning(winningNumbers, new LottoNumber(InputView.requestBonusNumber()));

        ResultView.printResult(toDto(LottoWinningScanner.result(lottos, winning, inputMoney)));
    }

    private static LottosDto toDto(List<Lotto> lottos) {
        List<LottoNumbersDto> numbersDtos = new ArrayList<>();
        for (Lotto lotto : lottos) {
            numbersDtos.add(createNumbersDto(lotto));
        }
        return new LottosDto(numbersDtos);
    }

    private static LottoNumbersDto createNumbersDto(Lotto lotto) {
        return new LottoNumbersDto(lotto.getLottoNumbers());
    }

    private static ResultDto toDto(LottoResult result) {
        List<WinningResult> winningResults = result.getWinningResults();
        return new ResultDto(result.getRate(), toDtos(winningResults));
    }

    private static List<PrizeMoneyDto> toDtos(List<WinningResult> winningResults) {
        List<PrizeMoneyDto> dtos = new ArrayList<>();
        for (WinningResult winningResult : winningResults) {
            Rank rank = winningResult.getRank();
            dtos.add(new PrizeMoneyDto(rank.getPrizeMoney(), winningResult.getCount(), rank.getCollectCount(), rank == Rank.SECOND));
        }
        return dtos;
    }

}
