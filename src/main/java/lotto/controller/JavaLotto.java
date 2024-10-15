package lotto.controller;

import lotto.dto.LottosDto;
import lotto.dto.LottoNumbersDto;
import lotto.dto.PrizeMoneyDto;
import lotto.dto.ResultDto;
import lotto.entity.*;
import lotto.entity.LottoMachine;
import lotto.entity.LottoWinningScanner;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class JavaLotto {

    private static final LottoWinningScanner lottoWinningScanner = new LottoWinningScanner();
    private static final InputView inputView = new InputView();
    private static final WinningText winningText = new WinningText();

    private JavaLotto() {

    }

    public static void run() {
        int inputMoney = inputView.requestBuyMoney();
        List<Lotto> lottos = LottoMachine.insert(inputMoney);
        ResultView.printCreateLotto(toDto(lottos));

        String text = inputView.requestWinnerNumber();
        List<Integer> winningNumbers = winningText.numbers(text);
        LottoResult result = lottoWinningScanner.result(lottos, winningNumbers, inputMoney);
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
            PrizeMoney prizeMoney = winningResult.getPrizeMoney();
            dtos.add(new PrizeMoneyDto(prizeMoney.getPrizeMoney(), winningResult.getCount(), prizeMoney.getCollectCount()));
        }
        return dtos;
    }

}
