package lotto;

import java.util.List;
import lotto.config.LottoFactory;
import lotto.controller.LottoController;
import lotto.dto.BuyLottosRq;
import lotto.dto.BuyLottosRs;
import lotto.dto.CreateRankStatisticsRq;
import lotto.dto.CreateRankStatisticsRs;
import lotto.dto.LottoMoneyDto;
import lotto.dto.LottosDto;
import lotto.exception.ExceptionSupplier;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMain {

    public static void main(String[] args) {
        LottoFactory lottoFactory = new LottoFactory();

        InputView inputView = lottoFactory.inputView();
        LottoController controller = lottoFactory.lottoController();
        OutputView outputView = lottoFactory.outputView();

        runLottoGame(inputView, controller, outputView);
    }

    private static void runLottoGame(InputView inputView, LottoController controller, OutputView outputView) {
        LottoMoneyDto lottoMoneyDto = getLottoMoneyDto(inputView, controller);
        long manualLottoCount = getManualLottoCount(inputView, lottoMoneyDto);
        LottosDto lottosDto = getLottosDto(inputView, manualLottoCount, controller,
                lottoMoneyDto.getNumberOfAllLottos(), outputView);
        informLottoRankStatistics(inputView, controller, lottosDto, lottoMoneyDto.getCost(), outputView);
    }

    private static LottoMoneyDto getLottoMoneyDto(InputView inputView, LottoController controller) {
        return ExceptionSupplier.<LottoMoneyDto>handleException(() -> createLottoMoneyDto(inputView, controller));
    }

    private static LottoMoneyDto createLottoMoneyDto(InputView inputView, LottoController controller) {
        long cost = inputView.moneyToBuyLotto();
        long numberOfAllLottos = controller.numberOfAllLottos(cost);
        return new LottoMoneyDto(cost, numberOfAllLottos);
    }

    private static long getManualLottoCount(InputView inputView, LottoMoneyDto lottoMoneyDto) {
        return inputView.manualLottoCount(lottoMoneyDto.getNumberOfAllLottos());
    }

    private static LottosDto getLottosDto(InputView inputView, long manualLottoCount, LottoController controller,
                                          long numberOfAllLottos, OutputView outputView) {
        return ExceptionSupplier.<LottosDto>handleException(
                () -> createLottosDto(inputView, manualLottoCount, controller, numberOfAllLottos, outputView));
    }

    private static LottosDto createLottosDto(InputView inputView, long manualLottoCount, LottoController controller,
                                             long numberOfAllLottos, OutputView outputView) {
        List<List<Integer>> manualLottos = inputView.manualLottos(manualLottoCount);

        BuyLottosRs buyLottosRs = controller.buyLottos(
                new BuyLottosRq(manualLottos, numberOfAllLottos, manualLottoCount));

        LottosDto lottosDto = buyLottosRs.getLottosDto();
        outputView.printPurchasedLottoCnt(manualLottoCount, buyLottosRs.getAutomaticLottoCount());
        outputView.printPurchasedLottos(lottosDto);

        return lottosDto;
    }

    private static void informLottoRankStatistics(InputView inputView, LottoController controller, LottosDto lottosDto,
                                                  long cost, OutputView outputView) {
        ExceptionSupplier.handleException(() ->
                createLottoRankStatistics(inputView, controller, lottosDto, cost, outputView));
    }

    private static void createLottoRankStatistics(InputView inputView, LottoController controller, LottosDto lottosDto,
                                                  long cost, OutputView outputView) {
        List<Integer> winnerLotto = inputView.winnerLottoNumbers();
        int bonusNumber = inputView.bonusNumber();

        CreateRankStatisticsRs createRankStatisticsRs = controller.informRankStatistics(
                new CreateRankStatisticsRq(lottosDto, winnerLotto, bonusNumber, cost));

        outputView.printLottoRankStatistics(createRankStatisticsRs.getRankResultDtos());
        outputView.printLottoYield(createRankStatisticsRs.getYield());
    }
}
