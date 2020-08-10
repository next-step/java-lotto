import domain.LottoGame;
import domain.LottoGames;
import domain.LottoMoney;
import domain.LottoWinningNumbers;
import view.InputView;
import view.OutputView;

import java.util.*;
import java.util.stream.Collectors;

public class LottoGameApp {
    public static void main(String[] args) {
        int money = InputView.getMoney();

        LottoMoney lottoMoney = new LottoMoney(money);
        List<LottoGame> lottoGameList = lottoMoney.generateLottoGame();
        LottoGames lottoGames = new LottoGames(lottoGameList);

        String winningNumberStr = InputView.getWinningNumberStr();
        List<Integer> winningNumberList = Arrays.stream(winningNumberStr.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(winningNumberList);

        OutputView.printLottoGames(lottoGameList);

        Map<Integer, Integer> winningStatistics = lottoGames.getWinningStatistics(lottoWinningNumbers);
        double benefitRate = lottoGames.getBenefitRate(winningStatistics, lottoMoney);


        OutputView.printWinningInfo(winningStatistics);

        OutputView.printBenefitRate(benefitRate);
    }
}
