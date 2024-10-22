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
        List<Lotto> lottos = LottoMachine.insert(inputMoney);
        ResultView.printCreateLotto(toDto(lottos));

        String[] texts = InputView.requestWinnerNumber();
        Set<Integer> winningNumbers = WinningTexts.numbers(texts);

        int bonusNumber = InputView.requestBonusNumber();

        Winning winning = new Winning(winningNumbers, bonusNumber);

        LottoResult result = LottoWinningScanner.result(lottos, winning, inputMoney);
        ResultView.printResult(toDto(result));
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
