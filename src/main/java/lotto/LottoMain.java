package lotto;

import java.util.List;
import lotto.config.LottoFactory;
import lotto.controller.LottoController;
import lotto.dto.CreateRankStatisticsDto;
import lotto.dto.LottosDto;
import lotto.dto.RankStatisticsDto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMain {

    public static void main(String[] args) {
        LottoFactory lottoFactory = new LottoFactory();

        InputView inputView = lottoFactory.inputView();
        LottoController controller = lottoFactory.lottoController();
        OutputView outputView = lottoFactory.outputView();

        long cost = inputView.moneyToBuyLotto();
        long lottoQuantity = controller.numberOfLottosToBuy(cost);
        outputView.printPurchasedLottoCnt(lottoQuantity);

        LottosDto lottosDto = controller.buyLottos(lottoQuantity);
        outputView.printPurchasedLottos(lottosDto);

        List<Integer> winnerLotto = inputView.winnerLottoNumbers();
        int bonusNumber = inputView.bonusNumber();
        RankStatisticsDto rankStatisticsDto = controller.informRankStatistics(
                new CreateRankStatisticsDto(lottosDto, winnerLotto, bonusNumber, cost));
        outputView.printLottoRankStatistics(rankStatisticsDto.getRankResultDtos());
        outputView.printLottoYield(rankStatisticsDto.getYield());
    }
}
