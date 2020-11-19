package lotto.controller;

import lotto.domain.*;
import lotto.dto.input.PurchaseDto;
import lotto.dto.input.WinningConditionDto;
import lotto.dto.result.LottosDto;
import lotto.dto.result.NumOfLottosDto;
import lotto.dto.result.StatisticsDto;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        PurchaseDto purchaseDto = InputView.getPurchaseDto();
        Shuffler shuffler = new Shuffler(LottoNo.MIN, LottoNo.MAX);
        Lottos lottos = new Lottos(
                purchaseDto.getPurchaseMoney(),
                purchaseDto.getManualLottos().stream().map((lotto) -> parseLotto(lotto)).collect(Collectors.toList()),
                () -> new Lotto(shuffler.getIntegers(Lotto.SIZE))
        );
        NumOfLottosDto numOfLottosDto = new NumOfLottosDto(lottos.getNumOfManualLottos(), lottos.getNumOfAutoLottos());
        ResultView.printNumOfLottos(numOfLottosDto);

        LottosDto lottosDto = new LottosDto(lottos);
        ResultView.printLottos(lottosDto);

        WinningConditionDto winningConditionDto = InputView.getWinningConditionDto();
        Result result = lottos.getResult(parseLotto(
                winningConditionDto.getWinningLotto()),
                LottoNoPool.getLottoNo(winningConditionDto.getBonus())
        );
        StatisticsDto statisticsDto = new StatisticsDto(result, lottos.getPurchaseMoney());
        ResultView.printStatistics(statisticsDto);
    }

    private static Lotto parseLotto(String lotto) {
        String splitRegex = "[ ,]+";
        return new Lotto(Splitter.splitStringToIntegers(lotto, splitRegex));
    }
}
