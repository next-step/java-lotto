package lotto.controller;

import java.util.List;
import lotto.dto.BuyLottosRequest;
import lotto.dto.BuyLottosResponse;
import lotto.dto.CreateRankStatisticsRequest;
import lotto.dto.CreateRankStatisticsResponse;
import lotto.dto.LottoMoneyDto;
import lotto.dto.LottosDto;
import lotto.exception.ExceptionSupplier;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(LottoService lottoService, InputView inputView, OutputView outputView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public LottoMoneyDto getLottoMoneyDto() {
        return ExceptionSupplier.<LottoMoneyDto>handleException(this::createLottoMoneyDto);
    }

    private LottoMoneyDto createLottoMoneyDto() {
        long cost = inputView.moneyToBuyLotto();
        long numberOfAllLottos = lottoService.numberOfAllLottos(cost);
        return new LottoMoneyDto(cost, numberOfAllLottos);
    }

    public long getManualLottoCount(LottoMoneyDto lottoMoneyDto) {
        return inputView.manualLottoCount(lottoMoneyDto.getNumberOfAllLottos());
    }

    public LottosDto getLottosDto(long manualLottoCount, long numberOfAllLottos) {
        return ExceptionSupplier.<LottosDto>handleException(() -> createLottosDto(manualLottoCount, numberOfAllLottos));
    }

    private LottosDto createLottosDto(long manualLottoCount, long numberOfAllLottos) {
        List<List<Integer>> manualLottos = inputView.manualLottos(manualLottoCount);

        BuyLottosResponse buyLottosResponse = lottoService.buyLottos(
                new BuyLottosRequest(manualLottos, numberOfAllLottos, manualLottoCount));

        LottosDto lottosDto = buyLottosResponse.getLottosDto();
        outputView.printPurchasedLottoCnt(manualLottoCount, buyLottosResponse.getAutomaticLottoCount());
        outputView.printPurchasedLottos(lottosDto);

        return lottosDto;
    }

    public void informLottoRankStatistics(LottosDto lottosDto, long cost) {
        ExceptionSupplier.handleException(() -> createLottoRankStatistics(lottosDto, cost));
    }

    private void createLottoRankStatistics(LottosDto lottosDto, long cost) {
        List<Integer> winnerLotto = inputView.winnerLottoNumbers();
        int bonusNumber = inputView.bonusNumber();

        CreateRankStatisticsResponse createRankStatisticsResponse = lottoService.informRankStatistics(
                new CreateRankStatisticsRequest(lottosDto, winnerLotto, bonusNumber, cost));

        outputView.printLottoRankStatistics(createRankStatisticsResponse.getRankResultDtos());
        outputView.printLottoYield(createRankStatisticsResponse.getYield());
    }
}
